package com.learn.forecast.domain.repository;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({RequestConfig.Key, RequestConfig.Days})
@Retention(RetentionPolicy.SOURCE)
public @interface RequestConfig {

    // better use c to prevent from reverse engineering
    String Key = "f8ab209fd3d541479e563343192506";

    String Days = "5";
}
