package datahelper.network;

import java.security.PublicKey;
import java.util.Map;

/**
 * Created by j-xuanyu on 2015/12/8.
 */
public class HttpRequest {
    private String url;

    public String getUrl() {
        return url;

    }

    public void setUrl(String url) {
        this.url = url;
    }

    private HttpClient.HttpMethod httpMethod = HttpClient.HttpMethod.GET;

    public HttpClient.HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpClient.HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    private String accept = "/*";

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAccept() {
        return accept;
    }

    private String contentType;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    private Map<String, String> headers;

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    private IHttpContent httpContent;

    public void setHttpContent(IHttpContent httpContent) {
        this.httpContent = httpContent;
    }

    public IHttpContent getHttpContent() {
        return httpContent;
    }
}
