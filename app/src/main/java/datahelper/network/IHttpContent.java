package datahelper.network;

import java.io.InputStream;

/**
 * Created by j-xuanyu on 2015/12/8.
 */
public interface IHttpContent {
    public String ReadAsString();
    public InputStream ReadAsInputStream();
    public byte[]  ReadAsByte();
}
