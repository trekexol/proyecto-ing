package ucab.ingsw.InstagramController.model;


import java.io.IOException;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.UnknownHostException;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ucab.ingsw.InstagramController.http.StreamUtils;

public class Response {

    private static final String EMPTY_RESPONSE = "";

    private String body;

    private int code;

    private Map<String, String> headers;

    private InputStream stream;

    private String url;

    Response(HttpURLConnection connection) throws IOException {
        try {
            connection.connect();

            url = connection.getURL().toString();
            code = connection.getResponseCode();
            headers = parseHeaders(connection);
            stream = wasSuccessful() ? connection.getInputStream() : connection.getErrorStream();
        } catch (UnknownHostException e) {
            code = HttpStatus.NOT_FOUND.value();
            body = EMPTY_RESPONSE;
        }
    }


    private boolean wasSuccessful() {
        return (getCode() >= 200) && (getCode() < 400);
    }

    /**
     * Obtains the HTTP Response body
     *
     * @return response body
     */

    public int getCode() {
        return code;
    }

    private Map<String, String> parseHeaders(HttpURLConnection conn) {
        Map<String, String> headers = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);

        for (java.util.Map.Entry<String,List<String>> entry : conn.getHeaderFields().entrySet()) {
            String key= entry.getKey();
            List<String> valueList= entry.getValue();
            if (key!=null && valueList!=null && valueList.size()>0) {
                String value= valueList.get(0);
                if (value!=null) {
                    headers.put(key, value);
                }
            }
        }
        return headers;
    }

    public String getURL() {
        return url;
    }

    public String getBody() {
        if (body == null) {
            body = parseBodyContents();
        }
        return body;
    }

    private String parseBodyContents() {
        return StreamUtils.getStreamContents(getStream());
    }

    public InputStream getStream() {
        return stream;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }


}
