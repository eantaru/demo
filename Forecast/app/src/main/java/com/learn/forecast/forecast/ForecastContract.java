package com.learn.forecast.forecast;

import com.learn.forecast.domain.repository.data.ApixuForecast;

public interface ForecastContract {

    interface View {
        void onForecast(ApixuForecast forecast);

        void onError();
    }

    interface Presenter {
        void requestForecast();
    }

}
