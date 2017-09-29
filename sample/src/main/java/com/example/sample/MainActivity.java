package com.example.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void doget(View view){
        //创建出主要的OkhttpClient的客户端对象。（一个执行者）
        OkHttpClient okHttpClient = new OkHttpClient();
        //request基于构造者模式
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url("http://www.imooc.com/").build();
        //call类似与runnable
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("wang", "onResponse: "+ response.body().string());
            }
        });
    }
}
