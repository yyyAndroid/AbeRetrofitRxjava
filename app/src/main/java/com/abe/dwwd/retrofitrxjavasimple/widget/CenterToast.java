package com.abe.dwwd.retrofitrxjavasimple.widget;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by abe on 2017/7/23.
 */

public class CenterToast{
  public static void show(Context context,String msg){
     Toast toast =  Toast.makeText(context,msg,Toast.LENGTH_SHORT);
      toast.setGravity(Gravity.CENTER,0,0);
      toast.show();
  }
}
