package com.abe.dwwd.retrofitrxjavasimple;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.abe.dwwd.retrofitrxjavasimple.adapter.MyViewPagerAdapter;

import cn.bmob.v3.Bmob;
import me.majiajie.pagerbottomtabstrip.MaterialMode;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends AppCompatActivity {
    NavigationController mNavigationController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBmob();

        PageBottomTabLayout pageBottomTabLayout = (PageBottomTabLayout) findViewById(R.id.tab);

        mNavigationController = pageBottomTabLayout.material()
                .addItem(R.mipmap.home,R.mipmap.home_false,"Movies & TV")
                .addItem(R.mipmap.business,R.mipmap.business_false, "Music")
                .addItem(R.mipmap.mine,R.mipmap.mine_false, "Books")
                .addItem(R.mipmap.find,R.mipmap.find_false, "Newsstand")
                .build();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));

        //自动适配ViewPager页面切换
        mNavigationController.setupWithViewPager(viewPager);

        //也可以设置Item选中事件的监听
        mNavigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                Log.i("asd","selected: " + index + " old: " + old);
            }

            @Override
            public void onRepeat(int index) {
                Log.i("asd","onRepeat selected: " + index);
            }
        });

        //设置消息圆点
//        mNavigationController.setMessageNumber(1,12);
//        mNavigationController.setHasMessage(1,true);
    }

    private void initBmob(){
        Bmob.initialize(this, "Your Application ID");
    }
}
