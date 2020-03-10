package com.learn.forecast;

import com.learn.forecast.base.BaseFragmentPagerAdapter;
import com.learn.forecast.base.ViewPagerAdapter;
import com.learn.forecast.di.components.DaggerMainActivityComponent;
import com.learn.forecast.di.components.MainActivityComponent;
import com.learn.forecast.di.modules.MainActivityModule;
import com.learn.forecast.domain.repository.data.ApixuForecast;
import com.learn.forecast.forecast.ErrorFragment;
import com.learn.forecast.forecast.ForecastContract;
import com.learn.forecast.forecast.ForecastFragment;
import com.learn.forecast.forecast.LoadingFragment;
import com.learn.forecast.view.FingerViewPager;
import com.learn.forecast.view.Screen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ForecastContract.View {

    @Inject
    ForecastContract.Presenter presenter;

    @Inject
    ForecastFragment forecastFragment;

    @Inject
    LoadingFragment loadingFragment;

    @Inject
    ErrorFragment errorFragment;

    FingerViewPager viewPager;

    private ViewPagerAdapter viewPagerAdapter;

    private MainActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();

        viewPager = findViewById(R.id.view_pager);

        viewPagerAdapter = ViewPagerAdapter.instance(viewPager, new ForecastPagerAdapter(
            getSupportFragmentManager(), Arrays.<Fragment>asList(loadingFragment, errorFragment,
            forecastFragment)));

        request();
    }

    private void initComponent() {
        component = DaggerMainActivityComponent.builder()
            .mainActivityModule(new MainActivityModule(this))
            .build();
        component.inject(this);
    }

    public void request() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                presenter.requestForecast();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 500L);
    }

    public void showScreen(@Screen int index) {
        viewPagerAdapter.showView(index);
    }

    @Override
    public void onForecast(ApixuForecast forecast) {
        showScreen(Screen.FORECAST);
        forecastFragment.updateForecast(forecast);
    }

    @Override
    public void onError() {
        showScreen(Screen.ERROR);
    }

    static class ForecastPagerAdapter extends BaseFragmentPagerAdapter {

        ForecastPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
            super(fragmentManager, fragments);
        }
    }
}
