package com.abe.dwwd.retrofitrxjavasimple.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.abe.dwwd.retrofitrxjavasimple.MainActivity;
import com.abe.dwwd.retrofitrxjavasimple.R;
import com.abe.dwwd.retrofitrxjavasimple.aidl.IMyAidlInterface;

/**
 * Created by abe on 2017/8/7.
 */

public class MyService extends Service {
    private static final String TAG = "MyService";


    @Override
    public void onCreate() {
        super.onCreate();
        /*Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_previous)
                .setTicker("新消息")
                .setContentTitle("通知标题")
                .setContentText("通知内容")
                .setContentIntent(pendingIntent);
        Notification notification = builder.getNotification();

        //设置为悬挂，主要设置 setFullScreenIntent
      *//*  if (Build.VERSION.SDK_INT >= 21){
            notification.setContentText("Heads-Up,Notification on5.0").setFullScreenIntent(pendingIntent, true);
        }*//*
       *//*notification.flags |= Notification.FLAG_AUTO_CANCEL;
           NotificationManager manager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(3, notification);*//*
        startForeground(1, notification);*/
        Log.e(TAG," onCreate() executed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG," onBind executed");
        return myBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG," onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy() ");
    }

    IMyAidlInterface.Stub   myBinder  = new IMyAidlInterface.Stub() {
        @Override
        public String basicTypes(String aString) throws RemoteException {

            return aString + "+AIDL";
        }
    };

    public class MyBinder extends Binder{
        public void startDownlod() {
            Log.e(TAG,"startDownload() executed");
            //执行具体的下载任务
        }
    }
}
