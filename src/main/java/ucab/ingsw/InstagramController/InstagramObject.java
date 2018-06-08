package ucab.ingsw.InstagramController;

import java.util.Map;


import ucab.ingsw.InstagramController.Exception.ApiLimitsUtils;


public abstract class InstagramObject  implements InstagramResponse{

   private Map<String, String> headers;


    void setHeaders(Map<String, String> headers){
        this.headers = headers;
    }


    public Map<String, String> getHeaders(){
        return this.headers;
    }


    public int getAPILimitStatus(){
        return ApiLimitsUtils.getAPILimitStatus(this.headers);
    }


    public int getRemainingLimitStatus(){
        return ApiLimitsUtils.getRemainingLimitStatus(this.headers);
    }

}
