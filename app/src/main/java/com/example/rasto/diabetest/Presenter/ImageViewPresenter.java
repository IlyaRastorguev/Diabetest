package com.example.rasto.diabetest.Presenter;

import android.view.View;

import com.example.rasto.diabetest.Constants.Fragments;
import com.example.rasto.diabetest.Fragments.ImageFragment;
import com.example.rasto.diabetest.Interfaces.PresenterInterface;
import com.example.rasto.diabetest.Model.ApplicationState;

/**
 * Created by irastorguev on 25.03.2018.
 */

public class ImageViewPresenter implements PresenterInterface.IBasicFragment {

    private ApplicationState APP_STATE;

    private ImageFragment imageView;

    public ImageViewPresenter(ImageFragment imageFragment) {
        this.imageView = imageFragment;
        APP_STATE = ApplicationState.getInstance();
    }


    @Override
    public boolean isFragmentActive() {
        if (APP_STATE.getCurrentActiveFragment() != Fragments.NULL) {
            return true;
        }
        return false;
    }

    @Override
    public void setSwipeListener(View view) {

    }

}
