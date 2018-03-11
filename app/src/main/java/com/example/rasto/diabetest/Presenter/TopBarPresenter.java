package com.example.rasto.diabetest.Presenter;

import com.example.rasto.diabetest.Interfaces.PresenterInterface;
import com.example.rasto.diabetest.Interfaces.Views.ITopBarView;
import com.example.rasto.diabetest.Model.ApplicationState;
import com.example.rasto.diabetest.R;

/**
 * Created by rasto on 3/10/2018.
 */

public class TopBarPresenter implements PresenterInterface.ITopBar {

    private ITopBarView topBarView;
    private ApplicationState applicationState;

    public TopBarPresenter(ITopBarView topBarView) {
        this.topBarView = topBarView;
        this.applicationState = ApplicationState.getInstance();
    }

    @Override
    public void stepBack() {

    }

    @Override
    public void stepForward() {

    }

    @Override
    public void setCurrentStep() {
        switch (applicationState.getCurrentScreen()) {
            case LOGIN:
                topBarView.setCurrentStep(R.string.login_step);
                break;
        }
    }
}
