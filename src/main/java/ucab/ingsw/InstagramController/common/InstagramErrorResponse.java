package ucab.ingsw.InstagramController.common;



import java.io.IOException;
import java.util.Map;


import com.google.gson.Gson;
import com.google.gson.JsonElement;

import ucab.ingsw.InstagramController.InstagramResponse;
import ucab.ingsw.InstagramController.Exception.InstagramException;




public class InstagramErrorResponse {

    private Meta errorMeta;


    private Map<String, String> headers;


    InstagramErrorResponse(Meta errorMeta) {
        this.errorMeta = errorMeta;
    }


    public static InstagramErrorResponse parse(Gson gson, String json) {
        JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
        JsonElement metaMember = null;
        if (jsonElement != null) {
            metaMember = jsonElement.getAsJsonObject().get("meta");
        }
        final Meta meta;
        if (metaMember != null) {
            meta = gson.fromJson(metaMember, Meta.class);
        } else {
            meta = gson.fromJson(jsonElement, Meta.class);
        }

        // Validate meta
        if (meta.getCode() != 0 && meta.getErrorType() != null) {
            return new InstagramErrorResponse(meta);
        } else {
            return new InstagramErrorResponse(null);
        }
    }

    public void setHeaders(Map<String, String> responseHeaders) {
        this.headers = responseHeaders;
    }


    public void throwException() throws InstagramException {
        if (errorMeta != null) {
            String msg = errorMeta.getErrorType() + ": " + errorMeta.getErrorMessage();
            switch (errorMeta.getCode()) {
                case 400:
                    throw new InstagramBadRequestException(errorMeta.getErrorType(), msg, this.headers);
                case 429:
                    throw new InstagramRateLimitException(errorMeta.getErrorType(), msg, this.headers);
                default:
                    throw new InstagramException(errorMeta.getErrorType(), msg, this.headers);
            }
        } else {
            throw new InstagramException("No metadata found in response", this.headers);
        }
    }

}
