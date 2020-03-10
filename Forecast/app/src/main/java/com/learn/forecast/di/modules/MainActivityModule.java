package com.learn.forecast.di.modules;

import com.learn.forecast.forecast.ForecastContract;
import com.learn.forecast.forecast.ForecastPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private final ForecastContract.View view;

    public MainActivityModule(ForecastContract.View view) {
        this.view = view;
    }

    @Provides
    ForecastContract.View provideView() {
        return view;
    }

    @Provides
    ForecastContract.Presenter providePresenter(ForecastPresenter presenter) {
        return presenter;
    }

}
