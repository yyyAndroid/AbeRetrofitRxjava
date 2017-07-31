package com.abe.dwwd.rxretrofithttputils.HttpInstance;


import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abe on 2017/7/28.
 */

public class SingleRxRetrofitHttp {
    private static SingleRxRetrofitHttp instance;

    private String baseUrl;

    private Map<String, Object> headerMaps = new HashMap<>();
    private boolean isShowLog = true;
    private boolean cache = false;
    private boolean saveCookie = true;

    private String cachePath;
    private long cacheMaxSize;
    private long writeTimeout = 10;
    private long readTimeout = 10;
    private long connectTimeout = 10;

    private OkHttpClient okHttpClient;

    public static SingleRxRetrofitHttp getInstance() {
        if (instance == null) {
            synchronized (SingleRxRetrofitHttp.class) {
                if (instance == null) {
                    instance = new SingleRxRetrofitHttp();
                }
            }
        }
        return instance;
    }

    public SingleRxRetrofitHttp baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public SingleRxRetrofitHttp addHeaders(Map<String, Object> headerMaps) {
        this.headerMaps = headerMaps;
        return this;
    }

    public SingleRxRetrofitHttp log(boolean isShowLog) {
        this.isShowLog = isShowLog;
        return this;
    }

    public SingleRxRetrofitHttp cache(boolean cache) {
        this.cache = cache;
        return this;
    }


    public SingleRxRetrofitHttp readTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public SingleRxRetrofitHttp writeTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    public SingleRxRetrofitHttp connectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public <K> K createSingleApi(Class<K> cls){
        return getSingleRetrofitBuilder().build().create(cls);
    }

    private Retrofit.Builder getSingleRetrofitBuilder() {
        Retrofit.Builder singleRetrofitBuilder = new Retrofit.Builder();
        singleRetrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient == null?getSingleOkHttpBuilder().build():okHttpClient);
        return singleRetrofitBuilder;
    }

    private OkHttpClient.Builder getSingleOkHttpBuilder() {
        OkHttpClient.Builder singleOkHttpBUilder = new OkHttpClient.Builder();
        singleOkHttpBUilder.retryOnConnectionFailure(true);
//        singleOkHttpBUilder.addInterceptor(new)
        if (isShowLog) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {

                @Override
                public void log(String message) {
                    Log.e("RxRetrofitHttpUtils:",message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            singleOkHttpBUilder.addInterceptor(loggingInterceptor);
        }
        singleOkHttpBUilder.readTimeout(readTimeout, TimeUnit.SECONDS);
        singleOkHttpBUilder.connectTimeout(readTimeout, TimeUnit.SECONDS);
        singleOkHttpBUilder.writeTimeout(readTimeout, TimeUnit.SECONDS);
        return singleOkHttpBUilder;
    }

}

