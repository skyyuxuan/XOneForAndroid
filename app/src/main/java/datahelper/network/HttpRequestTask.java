package datahelper.network;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by j-xuanyu on 2015/12/9.
 */
public class HttpRequestTask extends RequestTask {

    private HttpRequest httpRequest;


    public HttpRequestTask(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    protected void execute() {
        if (httpRequest != null) {
            HttpClient client = new HttpClient();
            try {
                HttpResponse response = client.sendHttpRequest(httpRequest);
                callback.onResponse(response);

            } catch(IOException exp){
                exp.printStackTrace();
            }
        }
    }
}
