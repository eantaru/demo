package com.learn.forecast.view;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({Screen.LOADING, Screen.ERROR, Screen.FORECAST})
@Retention(RetentionPolicy.SOURCE)
public @interface Screen {

    int LOADING = 0;

    int ERROR = 1;

    int FORECAST = 2;
}
