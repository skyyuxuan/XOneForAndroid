package datahelper.network;

import java.io.InputStream;

/**
 * Created by j-xuanyu on 2015/12/8.
 */
public class HttpStringContent implements IHttpContent {

    @Override
    public String ReadAsString() {
        return null;
    }

    @Override
    public InputStream ReadAsInputStream() {

        return null;
    }

    @Override
    public byte[] ReadAsByte() {
        return new byte[0];
    }
}
