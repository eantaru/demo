package com.learn.forecast.domain.repository;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apixu {

    private final String baseUrl = "http://api.apixu.com/v1/";

    @Inject
    public Apixu() {

    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                request = request.newBuilder()
                    .header("Accept", "application/json;odata=verbose")
                    .method(request.method(), request.body())
                    .build();
                return chain.proceed(request);
            }
        });

        return client.build();
    }

    public Retrofit getClient() {
        return new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(getOkHttpClient())
            .build();
    }
}
