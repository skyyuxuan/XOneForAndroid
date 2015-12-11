package datahelper.network;

import android.support.v4.app.NavUtils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Key;
import java.util.Map;


/**
 * Created by j-xuanyu on 2015/12/8.
 */
public class HttpClient {

    public enum HttpMethod {
        GET, POST, PUT, DELETE, OPTIONS, HEAD, TRACE, CONNECT;
    }

    public HttpResponse sendHttpRequest(HttpRequest request) throws IOException {

        HttpResponse response = new HttpResponse();
        if (request != null) {

            //Init httpUrlConnection
            URL url = new URL(request.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(request.getHttpMethod().name());
            if (request.getAccept() != null)
                connection.setRequestProperty("Accept", request.getAccept());
            if (request.getContentType() != null)
                connection.setRequestProperty("ContentType", request.getContentType());
            connection.setRequestProperty("User-Agent", "android");
            connection.setRequestProperty("Connection", "Keep-Alive");

            //set request headers
            if (request.getHeaders() != null) {
                for (String key : request.getHeaders().keySet()) {
                    connection.setRequestProperty(key, request.getHeaders().get(key));
                }
            }
            IHttpContent httpContent = request.getHttpContent();

            //set httpContent
            if (httpContent != null) {
                //set httpContent headers
                Map<String, String> headers = httpContent.getHeaders();
                if (headers != null) {
                    for (Map.Entry<String, String> entry : headers.entrySet()) {
                        connection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                connection.setDoOutput(true);
                httpContent.WriteToStream(connection.getOutputStream());
            }

            //get http return InputStream
            InputStream is = connection.getInputStream();
            response.setContent(new HttpContent(is));
            response.setStatusCode(connection.getResponseCode());

            //disconnect
            if (connection != null)
                connection.disconnect();
        }
        return response;
    }

    private void handleResponse(HttpURLConnection connection) {

    }

    private byte[] getResponseByteData(HttpURLConnection connection) {
        InputStream is = null;
        ByteArrayOutputStream bytestream = null;
        try {
            is = connection.getInputStream();
            if (is == null) return null;
            bytestream = new ByteArrayOutputStream();
            boolean stop = false;
            int ch;
            while ((ch = is.read()) != -1) {
                bytestream.write(ch);
            }
            if (stop) return null;
            return bytestream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                    is = null;
                }
                if (bytestream != null) {
                    bytestream.close();
                    bytestream = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
