package com.abe.dwwd.rxretrofithttputils.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by abe on 2017/7/31.
 */

public class UpLoadProgressInterceptor implements Interceptor {
    private UploadProgressListner mUploadListener;

    public UpLoadProgressInterceptor(UploadProgressListner mUploadListener) {
        this.mUploadListener = mUploadListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (null == request.body()){
            return chain.proceed(request);
        }

        Request build = request.newBuilder()
                .method(request.method()
                ,new ProgressReqeustBody(request.body(),mUploadListener))
                .build();
        return chain.proceed(build);
    }
}
