package com.example.rasto.diabetest.Presenter;

import android.view.View;

/**
 * Created by rasto on 2/25/2018.
 */

public class Presenter {
    private View currentView;

    public View getCurrentView() {
        return currentView;
    }

    public void setCurrentView(View currentView) {
        this.currentView = currentView;
    }
}
