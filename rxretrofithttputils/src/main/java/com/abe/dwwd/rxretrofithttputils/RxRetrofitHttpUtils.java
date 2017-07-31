package com.abe.dwwd.rxretrofithttputils;


import com.abe.dwwd.rxretrofithttputils.HttpInstance.GlobalRxHttp;
import com.abe.dwwd.rxretrofithttputils.HttpInstance.SingleRxRetrofitHttp;

/**
 * Created by abe on 2017/7/28.
 */

public class RxRetrofitHttpUtils {
    private static RxRetrofitHttpUtils instance;

    public static RxRetrofitHttpUtils getInstance(){
        if (instance == null){
            synchronized (RxRetrofitHttpUtils.class){
                if (instance == null){
                    instance = new RxRetrofitHttpUtils();
                }
            }
        }
        return instance;
    }

    public static SingleRxRetrofitHttp getSingleInstance(){
        return SingleRxRetrofitHttp.getInstance();
    }

    public GlobalRxHttp config() {
        return GlobalRxHttp.getInstance();
    }


    /**
     * 使用全局参数创建请求
     *
     * @param cls
     * @param <K>
     * @return
     */
    public static <K> K createApi(Class<K> cls) {
        return GlobalRxHttp.createGApi(cls);
    }

}
