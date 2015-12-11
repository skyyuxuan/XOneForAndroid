package datahelper.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by j-xuanyu on 2015/12/8.
 */
public abstract class IHttpContent {

    protected Map<String, String> headers;

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public abstract String ReadAsString() throws UnsupportedEncodingException;

    public abstract InputStream ReadAsInputStream() throws UnsupportedEncodingException;

    public abstract byte[] ReadAsByte() throws IOException;

    public abstract void WriteToStream(OutputStream outputStream) throws IOException;

}
