package com.abe.dwwd.rxretrofithttputils.HttpInstance;


import com.abe.dwwd.rxretrofithttputils.Client.RetrofitClient;
import com.abe.dwwd.rxretrofithttputils.interceptor.Transformer;
import com.abe.dwwd.rxretrofithttputils.interceptor.UpLoadProgressInterceptor;
import com.abe.dwwd.rxretrofithttputils.interceptor.UploadFileApi;
import com.abe.dwwd.rxretrofithttputils.interceptor.UploadProgressListner;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by allen on 2017/6/14.
 * <p>
 * 为上传单独建一个retrofit
 */

public class UploadRetrofit {

    private static UploadRetrofit instance;
    private Retrofit.Builder mRetrofitBulder;

    private static String baseUrl = "https://api.github.com/";


    private UploadRetrofit() {
        mRetrofitBulder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl);
    }

    public static UploadRetrofit getInstance() {

        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new UploadRetrofit();
                }
            }

        }
        return instance;
    }

    public Retrofit.Builder getRetrofitBuilder() {
        return mRetrofitBulder;
    }


    public static Observable<ResponseBody> uploadImg(String uploadUrl, List<String> filePaths, UploadProgressListner uploadProgressListner) {

//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        int i = 0;
        for (String filePath : filePaths) {
            File file = new File(filePath);
            builder.addFormDataPart("fileName" + i, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
            i++;
        }

      /*  MultipartBody.Part body =
                MultipartBody.Part.createFormData("uploaded_file", file.getName(), requestFile);
*/
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new UpLoadProgressInterceptor(uploadProgressListner))
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        return UploadRetrofit
                .getInstance()
                .getRetrofitBuilder()
                .client(okHttpClient)
                .build()
                .create(UploadFileApi.class)
                .uploadImg(uploadUrl, builder.build().parts())
                .compose(Transformer.<ResponseBody>switchSchedulers());
    }
}
