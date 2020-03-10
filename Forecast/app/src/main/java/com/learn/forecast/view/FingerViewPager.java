package com.learn.forecast.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class FingerViewPager extends ViewPager {

    // default false
    private boolean swipeable;

    public FingerViewPager(@NonNull Context context) {
        super(context);
    }

    public FingerViewPager(@NonNull Context context,
        @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSwipeable(boolean swipeable) {
        this.swipeable = swipeable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.swipeable && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.swipeable) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }
}
