package com.abe.dwwd.retrofitrxjavasimple;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by abe on 2017/7/25.
 */

public class App extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
