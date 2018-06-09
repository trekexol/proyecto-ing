package ucab.ingsw.InstagramController.Utils;

import org.apache.commons.lang3.StringUtils;

public class Precondition {


    private static final String DEFAULT_MESSAGE = "Received an invalid parameter";



    public static void checkNotNull(Object object, String errorMsg) {
        check(object != null, errorMsg);
    }


    private static void check(boolean requirements, String error) {
        String message = StringUtils.isBlank(error) ? DEFAULT_MESSAGE : error;

        if (!requirements) {
            throw new IllegalArgumentException(message);
        }
    }
}
