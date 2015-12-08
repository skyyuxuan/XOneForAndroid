package datahelper.network;



import java.util.List;
import java.util.Map;

/**
 * Created by j-xuanyu on 2015/12/8.
 */
public interface IHttpRequest {
    String Url = null;
    String Method = null;
    String ContentType = null;
    long ContentRange = 0;
    String Accept = null;
    Map<String, String> Headers = null;
    String Body = null;
}
