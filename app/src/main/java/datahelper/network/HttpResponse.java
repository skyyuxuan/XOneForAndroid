package datahelper.network;

/**
 * Created by j-xuanyu on 2015/12/9.
 */
public class HttpResponse {


    private int StatusCode ;

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    private IHttpContent content;

    public IHttpContent getContent() {
        return content;
    }

    void setContent(IHttpContent content) {
        this.content = content;
    }
}
