package com.abe.dwwd.retrofitrxjavasimple.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abe.dwwd.retrofitrxjavasimple.R;
import com.abe.dwwd.retrofitrxjavasimple.bean.BannerimageInfo;
import com.abe.dwwd.retrofitrxjavasimple.http.HttpApi;
import com.abe.dwwd.retrofitrxjavasimple.http.service.RequestInterface;
import com.abe.dwwd.rxretrofithttputils.HttpInstance.CommonObserver;
import com.abe.dwwd.rxretrofithttputils.RxRetrofitHttpUtils;
import com.abe.dwwd.rxretrofithttputils.interceptor.Transformer;
import com.abe.dwwd.rxretrofithttputils.base.ResultBean;
import io.reactivex.disposables.Disposable;


/**
 * Created by abe on 2017/7/24.
 */

public class HomeFragment extends BaseFragment {
    private static final String TAG = "HomeFragment";
    private TextView textView;
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home_layout,null);
        textView = (TextView) rootView.findViewById(R.id.home_tv);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadDate();
    }

    private void loadDate(){
        RxRetrofitHttpUtils.getSingleInstance()
                .baseUrl(HttpApi.BaseUrl)
                .log(true)
                .createSingleApi(RequestInterface.class)
                .getCall()
                .compose(Transformer.<ResultBean<BannerimageInfo>>switchSchedulers())
                .subscribe(new CommonObserver<ResultBean<BannerimageInfo>>() {
                    @Override
                    protected void getDisposable(Disposable d) {

                    }

                    @Override
                    protected void onError(String errorMsg) {

                    }

                    @Override
                    protected void onSuccess(ResultBean<BannerimageInfo> resultBean) {

                    }
                });
    }
}
