package ucab.ingsw.InstagramController;


import org.apache.commons.lang3.StringUtils;
/*
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import org.jinstagram.exceptions.InstagramException;
import org.jinstagram.http.Request;
import org.jinstagram.http.Response;
import org.jinstagram.http.URLUtils;
import org.jinstagram.http.Verbs;
import org.jinstagram.model.Methods;
import org.jinstagram.model.QueryParam;
import org.jinstagram.model.Relationship;
import org.jinstagram.utils.LogHelper;
import org.jinstagram.utils.PaginationHelper;
import org.jinstagram.utils.Preconditions;
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Proxy;
import java.net.SocketException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

import ucab.ingsw.InstagramController.InstagramClient;

public class InstagramBase /*implements InstagramClient*/ {

/*
    @Override
    @Deprecated
    public TagMediaFeed getRecentMediaTagsByRegularIds(String tagName, String minId, String maxId)
            throws InstagramException {
        Map<String, String> params = new HashMap<String, String>();

        if (!StringUtils.isEmpty(minId))
            params.put(QueryParam.MIN_ID, String.valueOf(minId));

        if (!StringUtils.isEmpty(maxId))
            params.put(QueryParam.MAX_ID, String.valueOf(maxId));

        String apiMethod = format(Methods.TAGS_RECENT_MEDIA, URLUtils.encodeURIComponent(tagName));
        String rawApiMethod = format(Methods.TAGS_RECENT_MEDIA, tagName);
        return createInstagramObject(Verbs.GET, TagMediaFeed.class, apiMethod, rawApiMethod, params);
    }*/
}
