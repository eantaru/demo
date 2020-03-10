package com.learn.forecast.forecast;

import com.learn.forecast.R;
import com.learn.forecast.base.BaseFragment;

import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import javax.inject.Inject;

public class LoadingFragment extends BaseFragment {

    ImageView ivCircle;

    @Inject
    public LoadingFragment() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_loading;
    }

    @Override
    protected void init() {
        ivCircle = getActivity().findViewById(R.id.circle_iv);

        ivCircle.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_clockwise));
    }
}
