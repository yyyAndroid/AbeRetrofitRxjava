package com.abe.dwwd.rxretrofithttputils.base;


import android.content.Context;

import com.abe.dwwd.rxretrofithttputils.Utils.CenterToast;
import com.abe.dwwd.rxretrofithttputils.exception.ApiException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by abe on 2017/7/28.
 */

public  abstract class BaseObserver<T> implements Observer<T>, ISubscriber<T>{
    Context context;

    public BaseObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        doOnSubscribe(d);
    }

    protected void doOnNetError() {
    }

    @Override
    public void onNext(@NonNull T t) {
        if (t instanceof ResultBean){
            if (((ResultBean) t).succeed){
                doOnNext(t);
            }else {
                setError(((ResultBean) t).errMsg);
            }
        }else {
            doOnNext(t);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (e instanceof SocketTimeoutException) {
            setError(ApiException.errorMsg_SocketTimeoutException);
        } else if (e instanceof ConnectException) {
            setError(ApiException.errorMsg_ConnectException);
        } else if (e instanceof UnknownHostException) {
            setError(ApiException.errorMsg_UnknownHostException);
        } else {
            String error = e.getMessage();
            showToast(error);
            doOnError(error);
        }
    }


    private void setError(String errorMsg) {
        showToast(errorMsg);
        doOnError(errorMsg);
        doOnNetError();
    }

    @Override
    public void onComplete() {
        doOnCompleted();
    }

    protected void showToast(String msg) {
        CenterToast.show(context,msg);
    }

}
