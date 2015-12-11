package com.xuanstudio.xone;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xuanstudio.xone.adapter.FlipAdapter;

import java.util.logging.LogRecord;

import datahelper.model.HomeData;
import datahelper.network.HttpClient;
import datahelper.network.HttpConnectionAsync;
import datahelper.network.HttpRequest;
import datahelper.network.HttpRequestTask;
import datahelper.network.StringResponseHandler;
import se.emilsjolander.flipview.FlipView;
import se.emilsjolander.flipview.OverFlipMode;

public class MainActivity extends AppCompatActivity {

    private FlipView mFlipView;
    private FlipAdapter mAdapter;
    Handler handler;
    HomeData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, HttpRequestTestActivity.class);
                startActivity(intent);
            }
        });

        mFlipView = (FlipView) findViewById(R.id.flipView);
        mAdapter = new FlipAdapter(this);
        mFlipView.setOverFlipMode(OverFlipMode.RUBBER_BAND);
        mFlipView.setAdapter(mAdapter);
        handler = new Handler() {
            public void handleMessage(Message msg) {
                for (HomeData.HomeDataItem item : data.HomeDataItems) {
                    mAdapter.addItems(item);
                }

            }
        };

        HttpConnectionAsync httpConnectionAsync = new HttpConnectionAsync();
        HttpRequest request = new HttpRequest();
        request.setHttpMethod(HttpClient.HttpMethod.GET);
        request.setUrl("http://bea.wufazhuce.com/OneForWeb/one/getHpAdMultiinfo");
        httpConnectionAsync.sendRequest(new HttpRequestTask(request),
                new StringResponseHandler() {
                    @Override
                    protected void onResponse(String content) {
                        System.out.println(content);
                        data = new HomeData();
                        data.Parse(content);
                        handler.sendMessage(new Message());
                    }
                });
    }
}
