package datahelper.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by j-xuanyu on 2015/12/11.
 */
public class HttpInputStreamContent extends IHttpContent {

    private InputStream content;

    public HttpInputStreamContent(InputStream content) {
        this.content = content;
    }

    @Override
    public String ReadAsString() throws UnsupportedEncodingException {
        return null;
    }

    @Override
    public InputStream ReadAsInputStream() throws UnsupportedEncodingException {
        return content;
    }

    @Override
    public byte[] ReadAsByte() throws IOException {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        while ((ch = content.read()) != -1) {
            bytestream.write(ch);
        }
        return bytestream.toByteArray();
    }

    @Override
    public void WriteToStream(OutputStream outputStream) throws IOException {
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int length = -1;
        while ((length = content.read(buffer)) != -1) {
            //write OutputStream
            outputStream.write(buffer, 0, length);
        }
    }
}
