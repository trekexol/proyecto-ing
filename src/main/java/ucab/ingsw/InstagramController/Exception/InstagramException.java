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
