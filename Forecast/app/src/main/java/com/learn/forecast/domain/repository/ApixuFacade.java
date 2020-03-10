package com.learn.forecast.domain.repository;

import com.learn.forecast.domain.repository.data.ApixuForecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApixuFacade {

    @GET("forecast.json")
    Call<ApixuForecast> getForecast(@Query("key") String key, @Query("q") String city,
        @Query("days") String day);
}
