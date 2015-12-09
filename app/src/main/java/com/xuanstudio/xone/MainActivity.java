package com.xuanstudio.xone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import datahelper.network.HttpClient;
import datahelper.network.HttpConnectionAsync;
import datahelper.network.HttpRequest;
import datahelper.network.HttpRequestTask;
import datahelper.network.StringResponseHandler;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        HttpClient client = new HttpClient();
//                        HttpRequest request = new HttpRequest();
//                        request.setHttpMethod("GET");
//                        request.setUrl("http://bea.wufazhuce.com/OneForWeb/one/getHp_N?strDate=2015-12-09&strRow=1");
//                        client.sendHttpRequest(request);
//                    }
//                });
//                thread.start();
                HttpConnectionAsync httpConnectionAsync = new HttpConnectionAsync();
                HttpRequest request = new HttpRequest();
                request.setHttpMethod("GET");
                request.setUrl("http://bea.wufazhuce.com/OneForWeb/one/getHp_N?strDate=2015-12-09&strRow=1");
                httpConnectionAsync.sendRequest(new HttpRequestTask(request),
                        new StringResponseHandler() {
                            @Override
                            protected void onResponse(String content) {
                                System.out.println(new String(content));
                            }
                        });

            }
        });
    }
}
