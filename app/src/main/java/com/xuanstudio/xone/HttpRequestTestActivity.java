package com.xuanstudio.xone;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import datahelper.model.HomeData;
import datahelper.network.HttpClient;
import datahelper.network.HttpConnectionAsync;
import datahelper.network.HttpFormUrlEncodedContent;
import datahelper.network.HttpRequest;
import datahelper.network.HttpRequestTask;
import datahelper.network.StringResponseHandler;

public class HttpRequestTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request_test);


        findViewById(R.id.btnFormUrlContent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpConnectionAsync httpConnectionAsync = new HttpConnectionAsync();
                HttpRequest request = new HttpRequest();
                Map<String, String> map = new HashMap<String, String>();
                map.put("apikey","0b2bdeda43b5688921839c8ecb20399b");
                map.put("start","1");
                map.put("count","20");
                HttpFormUrlEncodedContent content = new HttpFormUrlEncodedContent(map);
                request.setHttpContent(content);
                request.setHttpMethod(HttpClient.HttpMethod.POST);
                request.setUrl("https://api.douban.com/v2/movie/coming");
                httpConnectionAsync.sendRequest(new HttpRequestTask(request),
                        new StringResponseHandler() {
                            @Override
                            protected void onResponse(String content) {
                                System.out.println(content);
                            }
                        });
            }
        });


    }


}
