package com.abe.dwwd.retrofitrxjavasimple.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.abe.dwwd.retrofitrxjavasimple.R;
import com.abe.dwwd.retrofitrxjavasimple.service.AdditionService;
import com.abe.dwwd.retrofitrxjavasimple.service.MyService;

public class AidlActivity extends AppCompatActivity {
    IMyAidlInterface aidlService;
    Button button2,button3,button4,button5;
    TextView textView;
    MyService.MyBinder myBinder;
    ServiceConnection serviceConnection = new ServiceConntection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netty);
        textView = (TextView) findViewById(R.id.textView);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AidlActivity.this,MyService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private static final String TAG = "AidlActivity";
   class ServiceConntection implements ServiceConnection {

       @Override
       public void onServiceConnected(ComponentName name, IBinder service) {
           aidlService = IMyAidlInterface.Stub.asInterface(service);

           try {
               String a = aidlService.basicTypes("hello world");
               Log.e(TAG,a);
           } catch (RemoteException e) {
               e.printStackTrace();
           }
       }

       @Override
       public void onServiceDisconnected(ComponentName name) {

       }
   }

}
