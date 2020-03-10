package com.learn.forecast.forecast;

import com.learn.forecast.di.PerActivity;
import com.learn.forecast.domain.repository.Apixu;
import com.learn.forecast.domain.repository.ApixuFacade;
import com.learn.forecast.domain.repository.RequestConfig;
import com.learn.forecast.domain.repository.data.ApixuForecast;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@PerActivity
public class ForecastPresenter implements ForecastContract.Presenter {

    ForecastContract.View view;

    Apixu apixu;

    @Inject
    public ForecastPresenter(ForecastContract.View view, Apixu apixu) {
        this.view = view;
        this.apixu = apixu;
    }

    @Override
    public void requestForecast() {
        requestCityForecast("Denpasar");
    }

    private void requestCityForecast(String city) {
        ApixuFacade facade = apixu.getClient().create(ApixuFacade.class);
        Call<ApixuForecast> call = facade.getForecast(RequestConfig.Key, city,
            RequestConfig.Days);

        call.enqueue(new Callback<ApixuForecast>() {
            @Override
            public void onResponse(Call<ApixuForecast> call, Response<ApixuForecast> response) {
                ApixuForecast data = response.body();
                view.onForecast(data);
            }

            @Override
            public void onFailure(Call<ApixuForecast> call, Throwable t) {
                view.onError();
            }
        });
    }
}
