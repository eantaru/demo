package com.learn.forecast.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public abstract class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public BaseFragmentPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
        super(fragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int index) {
        return fragments.get(index);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
