package ucab.ingsw.InstagramController.common;

import java.util.Map;

import ucab.ingsw.InstagramController.Exception.InstagramException;

public class InstagramBadRequestException extends InstagramException{


    public InstagramBadRequestException(String exceptionType, String message, Map<String, String> responseHeaders) {
        super(exceptionType, message, responseHeaders);
    }
}
