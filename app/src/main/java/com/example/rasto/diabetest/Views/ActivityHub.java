package com.example.rasto.diabetest.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rasto.diabetest.Adapters.GetFragmentClassInstance;
import com.example.rasto.diabetest.Constants.Containers;
import com.example.rasto.diabetest.Constants.Screens;
import com.example.rasto.diabetest.Interfaces.Views.BasicView;
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
                    .add(containerId, getFragmentClassInstance.getFragmentInstance(screen))
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(containerId, getFragmentClassInstance.getFragmentInstance(screen))
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
        this.nextFragment(Screens.LOGIN, Containers.MAIN);
    }

    @Override
    public void nextFragment(Screens screen, Containers toContainer) {

        switch (toContainer) {
            case TOP:
                this.topContainerNotEmpty =
                        this.addFragment(screen, toContainer.getContainer(), topContainerNotEmpty);
                break;
            case MAIN:
                this.mainContainerNotEmpty =
                        this.addFragment(screen, toContainer.getContainer(), mainContainerNotEmpty);
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
}
