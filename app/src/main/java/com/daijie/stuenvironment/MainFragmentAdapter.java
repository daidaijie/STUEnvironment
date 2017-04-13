package com.daijie.stuenvironment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by liyujie on 2017/4/13.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(Dormitory.getDormitories().get(position));
    }

    @Override
    public int getCount() {
        return Dormitory.getDormitories().size();
    }
}
