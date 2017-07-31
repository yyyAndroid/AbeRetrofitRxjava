package com.abe.dwwd.rxretrofithttputils.HttpInstance;

import android.util.Log;

import com.abe.dwwd.rxretrofithttputils.Client.HttpClient;
import com.abe.dwwd.rxretrofithttputils.Client.RetrofitClient;
import com.abe.dwwd.rxretrofithttputils.interceptor.HeaderInterceptor;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by abe on 2017/7/31.
 */

public class GlobalRxHttp {
    private static GlobalRxHttp instance;

    public static GlobalRxHttp getInstance(){
        if (instance == null){
            synchronized (GlobalRxHttp.class){
                if (instance == null){
                    instance = new GlobalRxHttp();
                }
            }
        }
        return instance;
    }

    /**
     * 设置 baseUrl
     * @param baseUrl
     * @return
     */
    public GlobalRxHttp setBaseUrl(String baseUrl){
        getGlobalRetrofitBuilder().baseUrl(baseUrl);
        return this;
    }

    /**
     * 设置自己的client
     *
     * @param okClient
     * @return
     */
    public GlobalRxHttp setOkClient(OkHttpClient okClient) {
        getGlobalRetrofitBuilder().client(okClient);
        return this;
    }


    /**
     * 添加统一的请求头
     *
     * @param headerMaps
     * @return
     */
    public GlobalRxHttp setHeaders(Map<String, Object> headerMaps) {
        getGlobalOkHttpBuilder().addInterceptor(new HeaderInterceptor(headerMaps));
        return this;
    }

    /**
     * 是否开启请求日志
     *
     * @param isShowLog
     * @return
     */
    public GlobalRxHttp setLog(boolean isShowLog) {
        if (isShowLog) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.e("RxHttpUtils", message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            getGlobalOkHttpBuilder().addInterceptor(loggingInterceptor);
        }
        return this;
    }

    /**
     * 全局的 retrofit
     *
     * @return
     */
    public static Retrofit getGlobalRetrofit() {
        return RetrofitClient.getInstance().getRetrofit();
    }


    /**
     * 全局的 RetrofitBuilder
     *
     * @return
     */
    public Retrofit.Builder getGlobalRetrofitBuilder() {
        return RetrofitClient.getInstance().getRetrofitBuilder();
    }

    public OkHttpClient.Builder getGlobalOkHttpBuilder() {
        return HttpClient.getInstance().getBuilder();
    }

    /**
     * 使用全局变量的请求
     *
     * @param cls
     * @param <K>
     * @return
     */
    public static <K> K createGApi(final Class<K> cls) {
        return getGlobalRetrofit().create(cls);
    }
}
