package com.example.rasto.diabetest.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rasto.diabetest.Adapters.GetFragmentClassInstance;
import com.example.rasto.diabetest.Constants.Components;
import com.example.rasto.diabetest.Constants.ContainerType;
import com.example.rasto.diabetest.Constants.Containers;
import com.example.rasto.diabetest.Constants.Fragments;
import com.example.rasto.diabetest.Constants.Steps;
import com.example.rasto.diabetest.Interfaces.Views.BasicView;
import com.example.rasto.diabetest.Model.ApplicationState;
import com.example.rasto.diabetest.R;

public class ActivityHub extends AppCompatActivity implements BasicView {

    private GetFragmentClassInstance getFragmentClassInstance = new GetFragmentClassInstance();

    private static final ApplicationState APP_STATE = ApplicationState.getInstance();

    private void addFragment(Fragments screen, int containerId, boolean containerStatus, ContainerType containerType) {
        if (containerStatus && containerType == ContainerType.SINGLE) {
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
    }

    private boolean removeFragment(Fragments screen, int containerId) {
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
        APP_STATE.setCurrentAppStep(Steps.START);
        APP_STATE.setMainContainerState(ContainerType.MULTIPLY);
        this.setFragment(Fragments.LOGIN, Containers.MAIN);
        this.setFragment(Fragments.SING_UP, Containers.MAIN);
        this.setFragment(Fragments.TOP_BAR, Containers.TOP);
    }

    @Override
    public void setFragment(Fragments fragment, Containers toContainer) {
        switch (toContainer) {
            case TOP:
                this.addFragment(
                        fragment,
                        toContainer.getContainer(),
                        APP_STATE.isTopContainerNotEmpty(),
                        APP_STATE.getTopContainerState()
                );
                break;
            case MAIN:
                this.addFragment(
                        fragment,
                        toContainer.getContainer(),
                        APP_STATE.isMainContainerNotEmpty(),
                        APP_STATE.getMainContainerState()
                );
                break;
            case BOTTOM:
                this.addFragment(
                        fragment,
                        toContainer.getContainer(),
                        APP_STATE.isBottomContainerNotEmpty(),
                        APP_STATE.getBottomContainerState()
                );
                break;
            case LEFT:
                this.addFragment(
                        fragment,
                        toContainer.getContainer(),
                        APP_STATE.isLeftContainerNotEmpty(),
                        APP_STATE.getLeftContainerState()
                );
                break;
            case RIGHT:
                this.addFragment(
                        fragment,
                        toContainer.getContainer(),
                        APP_STATE.isRightContainerNotEmpty(),
                        APP_STATE.getRightContainerState()
                );
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
