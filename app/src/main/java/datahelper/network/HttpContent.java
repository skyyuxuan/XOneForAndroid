package datahelper.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by j-xuanyu on 2015/12/9.
 */
class HttpContent extends IHttpContent {
    private byte[] bytes = null;

    HttpContent(InputStream inputStream) {
        ByteArrayOutputStream bytestream = null;
        try {
            bytestream = new ByteArrayOutputStream();
            int ch;
            while ((ch = inputStream.read()) != -1) {
                bytestream.write(ch);
            }
            bytes = bytestream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bytestream != null) {
                    bytestream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String ReadAsString() {
        String data = null;
        if (bytes != null)
            data = new String(bytes);
        return data;
    }

    @Override
    public InputStream ReadAsInputStream() {
        InputStream is = null;
        if (bytes != null)
            is = new ByteArrayInputStream(bytes);
        return is;
    }

    @Override
    public byte[] ReadAsByte() {
        return bytes;
    }

    @Override
    public void WriteToStream(OutputStream outputStream) throws IOException {

    }
}
