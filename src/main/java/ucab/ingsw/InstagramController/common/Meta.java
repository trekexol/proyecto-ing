package ucab.ingsw.InstagramController.common;


import com.google.gson.annotations.SerializedName;


public class Meta {


   @SerializedName("code")
    private int code;

    @SerializedName("error_message")
    private String errorMessage;

    @SerializedName("error_type")
    private String errorType;

    public int getCode() {
        return code;
    }

    public String getErrorType() {
        return errorType;
    }


    public String getErrorMessage() {
        return errorMessage;
    }
}
