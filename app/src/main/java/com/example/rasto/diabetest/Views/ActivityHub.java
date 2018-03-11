package com.example.rasto.diabetest.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rasto.diabetest.Adapters.GetFragmentClassInstance;
import com.example.rasto.diabetest.Constants.Components;
import com.example.rasto.diabetest.Constants.Containers;
import com.example.rasto.diabetest.Constants.Screens;
import com.example.rasto.diabetest.Interfaces.Views.BasicView;
import com.example.rasto.diabetest.Model.ApplicationState;
import com.example.rasto.diabetest.R;

public class ActivityHub extends AppCompatActivity implements BasicView {

    private boolean topContainerNotEmpty = false;
    private boolean mainContainerNotEmpty = false;
    private boolean bottomContainerNotEmpty = false;
    private boolean leftContainerNotEmpty = false;
    private boolean rightContainerNotEmpty = false;

    private GetFragmentClassInstance getFragmentClassInstance = new GetFragmentClassInstance();

    private boolean addFragment(Screens screen, int containerId, boolean containerStatus) {
        if (containerStatus) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(containerId, getFragmentClassInstance.getFragmentInstance(screen))
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(containerId, getFragmentClassInstance.getFragmentInstance(screen))
                    .commit();
        }
        return true;
    }

    private boolean removeFragment(Screens screen, int containerId) {
        getSupportFragmentManager()
                .beginTransaction()
                .remove(getFragmentClassInstance.getFragmentInstance(screen))
                .commit();
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setFragment(Screens.LOGIN, Containers.MAIN);
        this.setFragment(Screens.TOP_BAR, Containers.TOP);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void setFragment(Screens screen, Containers toContainer) {
        final ApplicationState applicationState = ApplicationState.getInstance();
        switch (toContainer) {
            case TOP:
                this.topContainerNotEmpty =
                        this.addFragment(screen, toContainer.getContainer(), topContainerNotEmpty);
                break;
            case MAIN:
                this.mainContainerNotEmpty =
                        this.addFragment(screen, toContainer.getContainer(), mainContainerNotEmpty);
                applicationState.setCurrentScreen(screen);
                break;
            case BOTTOM:
                this.bottomContainerNotEmpty =
                        this.addFragment(screen, toContainer.getContainer(), bottomContainerNotEmpty);
                break;
            case LEFT:
                this.leftContainerNotEmpty =
                        this.addFragment(screen, toContainer.getContainer(), leftContainerNotEmpty);
                break;
            case RIGHT:
                this.rightContainerNotEmpty =
                        this.addFragment(screen, toContainer.getContainer(), rightContainerNotEmpty);
                break;
        }
    }

    @Override
    public void hideElement(Components elementType, int id) {

    }

    @Override
    public void showElement(Components elementType, int id) {

    }
}
