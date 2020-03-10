package com.learn.forecast.forecast;

import com.learn.forecast.MainActivity;
import com.learn.forecast.R;
import com.learn.forecast.base.BaseFragment;
import com.learn.forecast.view.Screen;

import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

public class ErrorFragment extends BaseFragment {

    Button button;

    @Inject
    public ErrorFragment() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_error;
    }

    @Override
    protected void init() {
        button = getActivity().findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).request();
                ((MainActivity) getActivity()).showScreen(Screen.LOADING);
            }
        });
    }
}
