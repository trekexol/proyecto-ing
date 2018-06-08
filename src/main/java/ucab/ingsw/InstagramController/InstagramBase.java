package ucab.ingsw.InstagramController;


import org.apache.commons.lang3.StringUtils;
/*
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
*/
import ucab.ingsw.InstagramController.Exception.InstagramException;
//import org.jinstagram.http.Request;
import ucab.ingsw.InstagramController.model.Response;
import ucab.ingsw.InstagramController.http.URLUtils;
import ucab.ingsw.InstagramController.http.Verbs;
import ucab.ingsw.InstagramController.model.Methods;
import ucab.ingsw.InstagramController.model.QueryParam;
/*import org.jinstagram.model.Relationship;
import org.jinstagram.utils.LogHelper;
import org.jinstagram.utils.PaginationHelper;
import org.jinstagram.utils.Preconditions;*/
import ucab.ingsw.InstagramController.Utils.Precondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Proxy;
import java.net.SocketException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

import ucab.ingsw.InstagramController.InstagramClient;

public class InstagramBase implements InstagramClient {

   protected final InstagramConfig config;

    protected static final Logger logger = LoggerFactory.getLogger(InstagramBase.class);

    public InstagramBase() {
        this(new InstagramConfig());
    }

    public InstagramBase(InstagramConfig config) {
       // Precondition.checkNotNull(config, "config cannot be null");
        this.config = config;
    }



    @Override
    public TagMediaFeed getRecentMediaTags(String tagName, String minTagId, String maxTagId) throws InstagramException {
        return getRecentMediaTags(tagName, minTagId, maxTagId, 0);
    }


    @Override
    public TagMediaFeed getRecentMediaTags(String tagName, String minTagId, String maxTagId, long count)
            throws InstagramException {
        Map<String, String> params = new HashMap<String, String>();

        if (!StringUtils.isEmpty(minTagId))
            params.put(QueryParam.MIN_TAG_ID, String.valueOf(minTagId));

        if (!StringUtils.isEmpty(maxTagId))
            params.put(QueryParam.MAX_TAG_ID, String.valueOf(maxTagId));

        if (count != 0) {
            params.put(QueryParam.COUNT, String.valueOf(count));
        }

        String apiMethod = format(Methods.TAGS_RECENT_MEDIA, URLUtils.encodeURIComponent(tagName));
        String rawApiMethod = format(Methods.TAGS_RECENT_MEDIA, tagName);

       // return createInstagramObject(Verbs.GET, TagMediaFeed.class, apiMethod, rawApiMethod, params);
        return null;
    }

    protected <T extends InstagramObject> T createInstagramObject(Verbs verbs, Class<T> clazz, String methodName,String rawMethodName, Map<String, String> params) throws InstagramException {
        Response response;
        String jsonResponseBody;
        try {
            response = getApiResponse(verbs, methodName, rawMethodName, params);

            if (config.isRetryOnServerError() && wasResponseAnError(response)) {
                Exception responseException = testResponseBody(response);

                int numberOfRetries = 2;
                int retryAttemptNumber = 0;
                while (responseException != null && retryAttemptNumber < numberOfRetries) {
                    try { Thread.sleep(1000); } catch (InterruptedException e) { /* ignore */ }
                    // Retry request
                    logger.warn("(Retry #{}) Retrying request for {}", retryAttemptNumber, response.getURL());
                    response = getApiResponse(verbs, methodName, rawMethodName, params);
                    responseException = testResponseBody(response);
                    retryAttemptNumber++;
                }
            }

            jsonResponseBody = response.getBody();
        //    LogHelper.prettyPrintJSONResponse(logger, jsonResponseBody);
        } catch (IOException e) {
           // throw new InstagramException("IOException while retrieving data", e);
        }

      //  Map<String, String> responseHeaders = response.getHeaders();
      //  if (response.getCode() >= 200 && response.getCode() < 300) {
          //  T object = createObjectFromResponse(clazz, jsonResponseBody);
        //    object.setHeaders(responseHeaders);
       //     return object;
      //  }

       // throw handleInstagramError(response.getCode(), jsonResponseBody, responseHeaders);
        return null;
    }

    protected Response getApiResponse(Verbs verb, String methodName, String rawMethodName, Map<String, String> params) throws IOException {
     //   Request request=request(verb, methodName, rawMethodName, params);
        logger.debug("Sending request to Instagram...");
      //  Response response=request.send();
     //   return response;
        return null;
    }

    private boolean wasResponseAnError(Response response) {
        return (response.getCode() >= 200 && response.getCode() < 300) || response.getCode() >= 500;
    }


    private Exception testResponseBody(Response response) {
      /*  Exception capturedException = null;
        int code = response.getCode();

        try {
            // get response entity, attempt parse as JSON.
            String jsonString = response.getBody();
            new Gson().fromJson(jsonString, JsonObject.class);
        } catch (IllegalStateException e) {
            // this indicates a socket error (e.g. connection reset) when attempting
            // to read HTTP response entity, capture the latest exception to be thrown
            // at the end
            capturedException = e;
            if (e.getCause() instanceof SocketException) {
                logger.warn(
                        format("Socket error with HTTP response (code %d).", code),
                        e.getCause());
            } else {
                logger.warn(
                        format("IllegalState exception with HTTP response (code %d).", code),
                        e.getCause());
            }
        } catch (JsonSyntaxException e) {
            // HTTP response body contained malformed JSON
            logger.warn(
                    format("HTTP response body contained malformed JSON (code %d).", code),
                    response.getCode());
            capturedException = e;
        }

        return capturedException;*/
      return null;
    }


}
