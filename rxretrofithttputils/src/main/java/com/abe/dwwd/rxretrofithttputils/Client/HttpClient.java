package com.abe.dwwd.rxretrofithttputils.Client;

import okhttp3.OkHttpClient;

/**
 * Created by abe on 2017/7/31.
 */

public class HttpClient {
    private static HttpClient instance;
    private OkHttpClient.Builder builder;

    private HttpClient(){
        builder = new OkHttpClient.Builder();
    }

    public static HttpClient getInstance(){
        if (instance == null){
            synchronized (HttpClient.class){
                if (instance == null){
                    instance = new HttpClient();
                }
            }
        }
        return instance;
    }

    public OkHttpClient.Builder getBuilder(){
        return builder;
    }


}
