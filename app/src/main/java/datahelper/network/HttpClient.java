package datahelper.network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;


/**
 * Created by j-xuanyu on 2015/12/8.
 */
public class HttpClient {

    public HttpResponse sendRequest(HttpRequest request) {
        HttpResponse response = null;
        if (request != null) {
            try {
                URL url = new URL(request.Url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                if (request.Accept != null)
                    connection.setRequestProperty("Accept", request.Accept);
                if (request.ContentType != null)
                    connection.setRequestProperty("ContentType", request.ContentType);
                for (String key : request.Headers.keySet()) {
                    connection.setRequestProperty(key, request.Headers.get(key));
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return response;
    }
}
