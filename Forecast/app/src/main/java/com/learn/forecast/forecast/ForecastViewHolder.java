package com.learn.forecast.forecast;

import com.learn.forecast.R;
import com.learn.forecast.base.BaseRecyclerViewHolder;
import com.learn.forecast.domain.repository.data.Forecastday;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForecastViewHolder extends BaseRecyclerViewHolder<Forecastday> {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final String DAY_FORMAT = "EEEE";

    private SimpleDateFormat inputFormat = new SimpleDateFormat(DATE_FORMAT);

    private SimpleDateFormat outputFormat = new SimpleDateFormat(DAY_FORMAT);

    private TextView tvDay;

    private TextView tvDegrees;

    public ForecastViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, R.layout.card_forecast, viewGroup);
    }

    @Override
    public void bindData(Forecastday forecastday) {
        tvDay = itemView.findViewById(R.id.day_tv);
        tvDegrees = itemView.findViewById(R.id.degrees_tv);

        String degrees = forecastday.getDay().getAvgtempC() + " C";

        tvDay.setText(getStringDay(forecastday.getDate()));
        tvDegrees.setText(degrees);
    }

    private String getStringDay(String dDate) {
        try {
            Date date = inputFormat.parse(dDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            return "";
        }

    }
}
