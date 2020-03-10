package com.learn.forecast.forecast;

import com.learn.forecast.base.BaseRecyclerViewAdapter;
import com.learn.forecast.base.BaseRecyclerViewHolder;
import com.learn.forecast.domain.repository.data.Forecastday;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class ForecastAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<Forecastday>,
    Forecastday> {

    public ForecastAdapter() {

    }

    @NonNull
    @Override
    public BaseRecyclerViewHolder<Forecastday> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ForecastViewHolder(viewGroup.getContext(), viewGroup);
    }
}
