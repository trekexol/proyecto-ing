package ucab.ingsw.InstagramController;

import java.util.Date;
import ucab.ingsw.InstagramController.Exception.InstagramException;

public interface InstagramClient {



    @Deprecated
    TagMediaFeed getRecentMediaTags(String tagName, String minTagId, String maxTagId) throws InstagramException;

    @Deprecated
    TagMediaFeed getRecentMediaTags(String tagName, String minTagId, String maxTagId, long count) throws InstagramException;
}
