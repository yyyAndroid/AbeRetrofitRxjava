package com.abe.dwwd.retrofitrxjavasimple;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.abe.dwwd.retrofitrxjavasimple.activity.BaseActivity;
import com.abe.dwwd.retrofitrxjavasimple.adapter.MyViewPagerAdapter;
import com.abe.dwwd.retrofitrxjavasimple.widget.CenterToast;


import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends BaseActivity {
    NavigationController mNavigationController;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        PageBottomTabLayout pageBottomTabLayout = (PageBottomTabLayout) findViewById(R.id.tab);
        mNavigationController = pageBottomTabLayout.material()
                .addItem(R.mipmap.home,R.mipmap.home_false,"主页")
                .addItem(R.mipmap.business,R.mipmap.business_false, "Music")
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

    private void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuId = item.getItemId();
                if (menuId == R.id.base_toolbar_pl){
                    CenterToast.show(MainActivity.this,"彭蕾");
                }else if (menuId == R.id.base_toolbar_zx){
                    CenterToast.show(MainActivity.this,"张旭");
                }
                return false;
            }
        });
        toolbar.setTitle("e家人");
    }
    private void initBmob(){
//        Bmob.initialize(this, "dff84fae5ac00d02d0034d1b13647429");
    }
}
