package com.learn.forecast.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * BaseView, base for custom view
 */
public abstract class BaseView extends FrameLayout {

    public abstract int getLayout();

    public abstract void setup();

    public BaseView(@NonNull Context context) {
        super(context);
    }

    public BaseView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(@NonNull Context context) {
        View view = View.inflate(context, getLayout(), this);

        setup();
    }
}
