package com.learn.forecast.view;

import com.learn.forecast.R;
import com.learn.forecast.base.BaseView;
import com.learn.forecast.domain.repository.data.Forecastday;
import com.learn.forecast.forecast.ForecastAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.List;

public class ForecastView extends BaseView {

    private RecyclerView rvForecast;

    private ForecastAdapter forecastAdapter;

    public ForecastView(@NonNull Context context) {
        super(context);
    }

    public ForecastView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ForecastView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayout() {
        return R.layout.view_forecast;
    }

    @Override
    public void setup() {
        rvForecast = getRootView().findViewById(R.id.forecast_rv);

        forecastAdapter = new ForecastAdapter();

        rvForecast.setNestedScrollingEnabled(false);
        rvForecast.setLayoutManager(new LinearLayoutManager(getContext()));
        rvForecast.setAdapter(forecastAdapter);
    }

    public void updateItems(List<Forecastday> forecastdays) {
        forecastAdapter.appendItems(forecastdays);
    }

//    private void demoItems() {
//        forecastAdapter.appendItems(Arrays.asList(new String[]{"Tuesday", "24 C"},
//            new String[]{"Wednesday", "25 C"}, new String[]{"Thursday", "26 C"},
//            new String[]{"Friday", "27 C"}));
//    }

}
