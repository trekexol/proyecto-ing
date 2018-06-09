package ucab.ingsw.InstagramController.Utils;

import org.slf4j.Logger;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class LogHelper {




    public static void prettyPrintJSONResponse(Logger logger, String jsonString) {
        if(logger.isDebugEnabled()) {
            // it can fail...on 404 it usually not a json
            String s;
            try {
                final JsonElement element = new JsonParser().parse(jsonString);
                s = new GsonBuilder().setPrettyPrinting().create().toJson(element);
            } catch(Exception e) {
                s = jsonString;
            }

            logger.debug("Received JSON response from Instagram - " + s);
        }
    }
}
