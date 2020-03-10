package com.learn.forecast.di.components;

import com.learn.forecast.MainActivity;
import com.learn.forecast.di.PerActivity;
import com.learn.forecast.di.modules.MainActivityModule;

import dagger.Component;

@PerActivity
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity view);
}
