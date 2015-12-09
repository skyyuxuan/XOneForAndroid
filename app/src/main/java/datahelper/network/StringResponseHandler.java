package datahelper.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Created by j-xuanyu on 2015/12/9.
 */
public abstract class StringResponseHandler implements ResponseCallback {
    @Override
    public void onResponse(HttpResponse response) {
        String data = null;
        if (response != null)
            data = response.getContent().ReadAsString();
        onResponse(data);
    }

    protected abstract void onResponse(String content);
}
