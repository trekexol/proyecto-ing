package ucab.ingsw.InstagramController;

import ucab.ingsw.InstagramController.model.Constants;


public class InstagramConfig {


    private String baseURI;
    private String version;
    private String apiURL;
    private boolean retryOnServerError = false;


    public boolean isRetryOnServerError() {
        return retryOnServerError;
    }

    public InstagramConfig() {
        baseURI = Constants.BASE_URI;
        version = Constants.VERSION;
        apiURL = Constants.API_URL;
    }
}
