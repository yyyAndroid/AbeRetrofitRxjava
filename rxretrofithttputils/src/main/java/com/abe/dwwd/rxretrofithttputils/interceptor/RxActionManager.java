package com.abe.dwwd.rxretrofithttputils.interceptor;


import io.reactivex.disposables.Disposable;

public interface RxActionManager<T> {

    void add(T tag, Disposable subscription);
    void remove(T tag);

   void cancel(T tag);

    void cancelAll();
}
