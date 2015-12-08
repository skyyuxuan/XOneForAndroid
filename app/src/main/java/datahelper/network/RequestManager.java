package datahelper.network;


import android.content.Context;
import android.os.AsyncTask;


import java.io.InputStream;
import java.util.Map;


/**
 * Created by j-xuanyu on 2015/12/8.
 */
public class RequestManager {
    private static RequestManager _instance;

    public static RequestManager getInstance(Context context) {
        if (_instance == null) {
            _instance = new RequestManager(context);
        }
        return _instance;
    }


    private RequestManager(Context context) {

    }



}
