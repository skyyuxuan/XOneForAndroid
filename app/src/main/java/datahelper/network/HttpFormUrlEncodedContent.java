package datahelper.network;

import android.util.ArrayMap;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by j-xuanyu on 2015/12/11.
 */
public class HttpFormUrlEncodedContent extends IHttpContent {


    private Map<String, String> content;

    public HttpFormUrlEncodedContent(Map<String, String> content) {

        if (headers == null)
            headers = new HashMap<>();
        headers.put("ContentType", "application/x-www-form-urlencoded");
        this.content = content;
    }

    @Override
    public String ReadAsString() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (String key : content.keySet()) {
            sb.append(key + "=" + content.get(key) + "&");
        }
        return sb.toString();
    }

    @Override
    public InputStream ReadAsInputStream() throws UnsupportedEncodingException {
        return new ByteArrayInputStream(ReadAsByte());
    }

    @Override
    public byte[] ReadAsByte() throws UnsupportedEncodingException {
        String str = ReadAsString();
        System.out.println(str);
        return str.getBytes();
    }

    @Override
    public void WriteToStream(OutputStream outputStream) throws IOException {

        outputStream.write(ReadAsByte());
    }
}
