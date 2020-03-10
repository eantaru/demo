package com.learn.forecast.forecast;

import com.learn.forecast.R;
import com.learn.forecast.base.BaseFragment;
import com.learn.forecast.domain.repository.data.ApixuForecast;
import com.learn.forecast.domain.repository.data.Forecastday;
import com.learn.forecast.view.ForecastView;

import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

public class ForecastFragment extends BaseFragment {

    private ForecastView forecastView;

    private TextView tvDegrees;

    private TextView tvCity;

    @Inject
    public ForecastFragment() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_forecast;
    }

    @Override
    protected void init() {
        tvCity = getActivity().findViewById(R.id.city_tv);

        tvDegrees = getActivity().findViewById(R.id.degrees_tv);

        forecastView = getActivity().findViewById(R.id.forecast);

        forecastView.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up));
    }

    public void updateForecast(ApixuForecast forecast) {
        String degrees = forecast.getCurrent().getTempC() + "°";

        tvDegrees.setText(degrees);
        tvCity.setText(forecast.getLocation().getName());

        List<Forecastday> forecastdays = forecast.getForecast().getForecastday();
        forecastdays.remove(0);

        forecastView.updateItems(forecastdays);
    }
}
