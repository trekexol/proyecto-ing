package ucab.ingsw.InstagramController;

import ucab.ingsw.InstagramController.model.Constants;


public class InstagramConfig {


    private String baseURI;
    private String version;
    private String apiURL;
    private int connectionTimeoutMills = 0;
    private int readTimeoutMills = 0;
    private boolean connectionKeepAlive = false;



    private boolean retryOnServerError = false;


    public boolean isRetryOnServerError() {
        return retryOnServerError;
    }

    public InstagramConfig() {
        baseURI = Constants.BASE_URI;
        version = Constants.VERSION;
        apiURL = Constants.API_URL;
    }


    public String getApiURL() {
        return apiURL;
    }

    public int getConnectionTimeoutMills() {
        return connectionTimeoutMills;
    }

    public int getReadTimeoutMills() {
        return readTimeoutMills;
    }

    public boolean isConnectionKeepAlive() {
        return connectionKeepAlive;
    }



}
