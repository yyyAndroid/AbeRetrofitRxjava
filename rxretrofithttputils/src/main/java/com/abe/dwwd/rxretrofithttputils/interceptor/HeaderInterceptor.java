package com.abe.dwwd.rxretrofithttputils.interceptor;


import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Allen on 2017/5/3.
 * <p>
 * 请求拦截器  统一添加请求头使用
 */

public class HeaderInterceptor implements Interceptor {

    private Map<String, Object> headerMaps = new TreeMap<>();

    public HeaderInterceptor(Map<String, Object> headerMaps) {
        this.headerMaps = headerMaps;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder request = chain.request().newBuilder();
        if (headerMaps != null && headerMaps.size() > 0) {
            for (Map.Entry<String, Object> entry : headerMaps.entrySet()) {
                request.addHeader(entry.getKey(), (String) entry.getValue());
            }
        }
//        else {
//            request
//                    .addHeader("Content-type", "application/json")
//                    .addHeader("Version", getAppVersion())
//                    .addHeader("uuid", getUUID())
//                    .addHeader("User-Agent", System.getProperty("http.agent"));
//        }


        return chain.proceed(request.build());
    }

/*
    private String getUUID() {
        return AppUtils.getUUID();
    }

    private String getAppVersion() {
        return AppUtils.getAppVersion();
    }
*/

}