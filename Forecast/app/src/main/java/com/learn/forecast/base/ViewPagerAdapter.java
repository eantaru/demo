package com.learn.forecast.base;

import android.support.v4.view.ViewPager;

public class ViewPagerAdapter {

    private ViewPager viewPager;

    private BaseFragmentPagerAdapter fragmentPagerAdapter;

    private ViewPagerAdapter(ViewPager viewPager, BaseFragmentPagerAdapter fragmentPagerAdapter) {
        this.viewPager = viewPager;
        this.fragmentPagerAdapter = fragmentPagerAdapter;

        this.viewPager.setAdapter(this.fragmentPagerAdapter);
    }

    public static ViewPagerAdapter instance(ViewPager viewPager,
        BaseFragmentPagerAdapter fragmentPagerAdapter) {
        return new ViewPagerAdapter(viewPager, fragmentPagerAdapter);
    }

    public void showView(int index) {
        viewPager.setCurrentItem(index, false);
    }

}
