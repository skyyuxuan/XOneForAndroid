package datahelper.network;

import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.util.ArrayMap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by j-xuanyu on 2015/12/11.
 */
public class HttpMultipartFormDataContent extends IHttpContent {

    private String boundary = "*****";
    private IHttpContent content;


    public HttpMultipartFormDataContent() {
        if (headers == null)
            headers = new HashMap<String, String>();
        headers.put("Content-Type", "multipart/form-data;boundary=" + boundary);
    }

    public HttpMultipartFormDataContent(String boundary) {
        if (headers == null)
            headers = new HashMap<String, String>();
        this.boundary = boundary;
        headers.put("Content-Type", "multipart/form-data;boundary=" + boundary);
    }

    public void Add(IHttpContent content, String name) {
        Add(content, name, "");
    }

    public void Add(IHttpContent content, String name, String fileName) {
        if (headers == null)
            headers = new HashMap<String, String>();
        headers.put(name, fileName);
        this.content = content;
    }


    @Override
    public String ReadAsString() throws UnsupportedEncodingException {
        return null;
    }

    @Override
    public InputStream ReadAsInputStream() throws UnsupportedEncodingException {
        return null;
    }

    @Override
    public byte[] ReadAsByte() throws UnsupportedEncodingException {
        return new byte[0];
    }

    @Override
    public void WriteToStream(OutputStream outputStream) throws IOException {
        outputStream.write(content.ReadAsByte());
    }
}
