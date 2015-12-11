package datahelper.network;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by j-xuanyu on 2015/12/8.
 */
public class HttpStringContent extends IHttpContent {

    private String content;

    private String charset = "unicode";

    public HttpStringContent(String content) {
        this.content = content;
    }

    public HttpStringContent(String content, String charset) {
        this.content = content;
        this.charset = charset;
    }

    @Override
    public String ReadAsString() throws UnsupportedEncodingException {
        return new String(content.getBytes(), charset);
    }

    @Override
    public InputStream ReadAsInputStream() {
        return new ByteArrayInputStream(content.getBytes());
    }

    @Override
    public byte[] ReadAsByte() {
        return content.getBytes();
    }

    @Override
    public void WriteToStream(OutputStream outputStream) throws IOException {
        outputStream.write(content.getBytes());
    }


}
