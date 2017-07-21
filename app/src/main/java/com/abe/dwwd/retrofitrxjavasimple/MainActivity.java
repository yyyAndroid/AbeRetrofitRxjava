package com.abe.dwwd.retrofitrxjavasimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBmob();
    }

    private void initBmob(){
        Bmob.initialize(this, "Your Application ID");
    }
}
