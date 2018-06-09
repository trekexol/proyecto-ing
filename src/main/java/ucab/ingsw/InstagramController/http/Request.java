package ucab.ingsw.InstagramController.http;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Request {


    private static final String CONTENT_LENGTH = "Content-Length";

    private String payload = null;

    private boolean connectionKeepAlive = false;

    private Map<String, String> bodyParams;

    private String charset;

    private HttpURLConnection connection;

    private Map<String, String> headers;

    private Map<String, String> querystringParams;

    private String url;

    private Verbs verb;

    private int connectTimeout;

    private int readTimeout;

    private Proxy proxy;


    public Request(Verbs verb, String url) {
        this.verb = verb;
        this.url = url;
        this.querystringParams = new HashMap<String, String>();
        this.bodyParams = new HashMap<String, String>();
        this.headers = new HashMap<String, String>();
    }

    public String getUrl() {
        return url;
    }


    public void setConnectTimeout(int duration, TimeUnit unit) {
        this.connectTimeout = (int) unit.toMillis(duration);
    }

    /**
     * Gets the connect timeout in millisecond units
     */
    public int getConnectTimeoutInMillis() {
        return connectTimeout;
    }

    public void setReadTimeout(int duration, TimeUnit unit) {
        this.readTimeout = (int) unit.toMillis(duration);
    }


    public void setConnectionKeepAlive(boolean connectionKeepAlive) {
        this.connectionKeepAlive = connectionKeepAlive;
    }

}
