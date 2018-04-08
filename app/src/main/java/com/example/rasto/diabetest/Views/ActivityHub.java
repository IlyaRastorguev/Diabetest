package com.example.rasto.diabetest.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.rasto.diabetest.Adapters.GetFragmentClassInstance;
import com.example.rasto.diabetest.Constants.Components;
import com.example.rasto.diabetest.Constants.ContainerType;
import com.example.rasto.diabetest.Constants.Containers;
import com.example.rasto.diabetest.Constants.Fragments;
import com.example.rasto.diabetest.Constants.Steps;
import com.example.rasto.diabetest.Interfaces.Views.ActivityHubView;
import com.example.rasto.diabetest.Interfaces.Views.BasicView;
import com.example.rasto.diabetest.Model.ApplicationState;
import com.example.rasto.diabetest.Presenter.ActivityHubPresenter;
import com.example.rasto.diabetest.R;

public class ActivityHub extends AppCompatActivity implements BasicView, ActivityHubView {

    private ActivityHubPresenter activityHubPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.activityHubPresenter = new ActivityHubPresenter(this);
        this.activityHubPresenter.onStart();
        this.activityHubPresenter.stepController(Steps.LOGIN);
    }

    @Override
    public void hideElement(Components elementType, int id) {

    }

    @Override
    public void showElement(Components elementType, int id) {

    }

    @Override
    public View getView() {
        return null;
    }

    @Override
    public void startCallBacks() {
        this.activityHubPresenter.fragmentsCallBack();
    }
}
