package ucab.ingsw.InstagramController.Exception;


import java.io.IOException;
import java.util.Map;

import ucab.ingsw.InstagramController.InstagramResponse;


public class InstagramException extends IOException implements InstagramResponse {

    private final Map<String, String> headers;

    private final String errorType;

    public InstagramException(String message) {
        super(message, null);
        this.headers = null;
        this.errorType = null;
    }


    public InstagramException(String message, Map<String, String> responseHeaders) {
        super(message, null);
        this.headers = responseHeaders;
        this.errorType = null;
    }

    public InstagramException(String exceptionType, String message, Map<String, String> responseHeaders) {
        super(message, null);
        this.headers = responseHeaders;
        this.errorType = exceptionType;
    }


    public InstagramException(String message, Exception e) {
        super(message, e);
        this.headers = null;
        this.errorType = null;

    }


    public InstagramException(String message, Exception e, Map<String, String> responseHeaders) {
        super(message, e);
        this.headers = responseHeaders;
        this.errorType = null;
    }


    @Override
    public int getAPILimitStatus() {
        if (headers == null) {
            return -1;
        } else {
            return ApiLimitsUtils.getAPILimitStatus(this.headers);
        }
    }

    @Override
    public int getRemainingLimitStatus() {
        if (headers == null) {
            return -1;
        } else {
            return ApiLimitsUtils.getRemainingLimitStatus(this.headers);
        }
    }
}
