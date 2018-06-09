package ucab.ingsw.InstagramController.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class StreamUtils {

    private StreamUtils() {}


   public static String getStreamContents(InputStream is) {
     //   Preconditions.checkNotNull(is, "Cannot get String from a null object");

        try {
            final char[] buffer = new char[0x10000];
            StringBuilder out = new StringBuilder();
            Reader in = new InputStreamReader(is, "UTF-8");
            int read;

            do {
                read = in.read(buffer, 0, buffer.length);

                if (read > 0) {
                    out.append(buffer, 0, read);
                }
            } while (read >= 0);

            in.close();

            return out.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Error while reading response body", ioe);
        }
    }
}
