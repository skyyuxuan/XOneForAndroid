package datahelper.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

/**
 * Created by j-xuanyu on 2015/12/9.
 */
public abstract class StringResponseHandler implements ResponseCallback {
    @Override
    public void onResponse(HttpResponse response) {
        String data = null;
        if (response != null)
            try {
                data = response.getContent().ReadAsString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        onResponse(data);
    }

    protected abstract void onResponse(String content);
}
