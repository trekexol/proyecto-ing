package ucab.ingsw.InstagramController.Exception;



import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import java.util.Map;

public final class ApiLimitsUtils {

    private static final Logger logger = LoggerFactory.getLogger(ApiLimitsUtils.class);


    protected static final String LIMIT_HEADER_KEY = "X-Ratelimit-Limit";


    protected static final String REMAINING_HEADER_KEY = "X-Ratelimit-Remaining";

    public static int getAPILimitStatus(Map<String, String> headers) {
        return ApiLimitsUtils.getIntegerValue(headers, LIMIT_HEADER_KEY);
    }

    public static int getRemainingLimitStatus(Map<String, String> headers) {
        return ApiLimitsUtils.getIntegerValue(headers, REMAINING_HEADER_KEY);
    }


    private static int getIntegerValue(Map<String, String> header, String key) {
        String intValueStr = header.get(key);
        if (intValueStr == null) {
            intValueStr = header.get(key.toLowerCase());
        }
        int value = -1;

        try {
            value = Integer.valueOf(intValueStr);
        } catch (NumberFormatException e) {
            logger.error("Invalid Integer value for key: " + key + ", value :" + intValueStr);
        }
        return value;
    }
}
