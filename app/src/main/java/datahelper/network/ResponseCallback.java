package datahelper.network;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by j-xuanyu on 2015/12/9.
 */
public interface ResponseCallback {

    void onResponse(HttpResponse response);
}
