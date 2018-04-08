package com.example.rasto.diabetest.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;

import com.example.rasto.diabetest.Interfaces.FragmentCallBack;
import com.example.rasto.diabetest.Interfaces.SwipeCallback;
import com.example.rasto.diabetest.Model.ApplicationState;
import com.example.rasto.diabetest.Presenter.ImageViewPresenter;
import com.example.rasto.diabetest.R;

import static com.example.rasto.diabetest.Constants.EventDirection.*;
import static com.example.rasto.diabetest.Constants.Fragments.*;

/**
 * Created by irastorguev on 25.03.2018.
 */

public class ImageFragment extends Fragment implements FragmentCallBack, SwipeCallback {

    private View view;

    private final ApplicationState APP_STATE = ApplicationState.getInstance();

    private ImageViewPresenter imageViewPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.sing_in_login_image, container, false);
        imageViewPresenter = new ImageViewPresenter(this);
        return view;
    }

    @Override
    public void callBackHandler() {
        switch (APP_STATE.getCurrentActiveFragment()) {
            case LOGIN:
            case SING_UP:
                view.setTranslationY(-96);
                view.setAlpha(0);
                break;
            case NULL:
                view.setTranslationY(0);
                view.setAlpha(1);
                break;
        }
    }

    @Override
    public void swipeCallBackHandler() {
        final float moveDistance = Math.abs(APP_STATE.getLastPoint().getY() - APP_STATE.getCurrentPoint().getY());
        switch (APP_STATE.getEventDirection()) {
            case TOP:
                if (view.getY() -  moveDistance * 0.2 > -96 ) {
                    view.setAlpha(Float.parseFloat(String.format("%s", view.getAlpha() - 0.02)));
                    view.setTranslationY(Math.round(view.getY() - moveDistance * 0.5));
                } else {
                    view.setAlpha(0);
                }
                break;
            case DOWN:
                if (view.getY() +  moveDistance * 0.2 <= 0) {
                    view.setAlpha(Float.parseFloat(String.format("%s", view.getAlpha() + 0.02)));
                    view.setTranslationY(Math.round(view.getY() + moveDistance * 0.5));
                } else {
                    view.setAlpha(1);
                    view.setTranslationY(0);
                }
                break;
        }
    }
}
