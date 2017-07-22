package com.abe.dwwd.retrofitrxjavasimple.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private int size;
    private List<Fragment> fragmentList;
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        fragmentList.add(AFragment.newInstance("1"));
        fragmentList.add(AFragment.newInstance("2"));
        fragmentList.add(AFragment.newInstance("3"));
        fragmentList.add(AFragment.newInstance("4"));
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
