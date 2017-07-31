package com.abe.dwwd.retrofitrxjavasimple.http.service;






import com.abe.dwwd.retrofitrxjavasimple.bean.BannerimageInfo;
import com.abe.dwwd.rxretrofithttputils.base.ResultBean;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by abe on 2017/7/25.
 */

public interface RequestInterface {

    @GET("getBanner.action")
    Observable<ResultBean<BannerimageInfo>> getCall();
}
