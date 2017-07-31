package com.abe.dwwd.rxretrofithttputils.Client;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abe on 2017/7/31.
 */

public class RetrofitClient {
    private static RetrofitClient instance;

    private Retrofit.Builder mRetrofitBuilder;
    private OkHttpClient.Builder mOkHttpBuiler;

    private RetrofitClient(){
        mOkHttpBuiler = HttpClient.getInstance().getBuilder();

        mRetrofitBuilder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpBuiler.build());
    }

    public static RetrofitClient getInstance(){
        if (instance == null){
            synchronized (RetrofitClient.class){
                if (instance == null){
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }

    public Retrofit.Builder getRetrofitBuilder(){
        return mRetrofitBuilder;
    }

    public Retrofit getRetrofit(){
        return mRetrofitBuilder.client(mOkHttpBuiler.build()).build();
    }

}
