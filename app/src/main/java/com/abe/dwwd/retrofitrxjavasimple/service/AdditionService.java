package com.abe.dwwd.retrofitrxjavasimple.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.abe.dwwd.retrofitrxjavasimple.aidl.IMyAidlInterface;

/**
 * Created by abe on 2017/8/7.
 */

public class AdditionService extends Service{

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }


}
