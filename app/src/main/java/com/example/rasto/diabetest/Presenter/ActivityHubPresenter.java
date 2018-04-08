package com.example.rasto.diabetest.Presenter;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.rasto.diabetest.Adapters.GetFragmentClassInstance;
import com.example.rasto.diabetest.Adapters.SwipeController;
import com.example.rasto.diabetest.Constants.ContainerType;
import com.example.rasto.diabetest.Constants.Fragments;
import com.example.rasto.diabetest.Constants.Steps;
import com.example.rasto.diabetest.Interfaces.PresenterInterface;
import com.example.rasto.diabetest.Interfaces.SwipeCallback;
import com.example.rasto.diabetest.Interfaces.Views.ActivityHubView;
import com.example.rasto.diabetest.Interfaces.FragmentCallBack;
import com.example.rasto.diabetest.Model.ApplicationState;

/**
 * Created by irastorguev on 24.03.2018.
 */

public class ActivityHubPresenter implements PresenterInterface, PresenterInterface.IActivityHub {

    private AppCompatActivity activity;

    private static final ApplicationState APP_STATE = ApplicationState.getInstance();

    private GetFragmentClassInstance getFragmentClassInstance = new GetFragmentClassInstance();

    public ActivityHubPresenter(AppCompatActivity activity) {
        this.activity = activity;
        APP_STATE.setController((ActivityHubView) activity);
    }

    @Override
    public void fragmentsCallBack() {
        switch (APP_STATE.getEventType()) {
            case CLICK:
                for(Fragment fragment: FRAGMENTS) {
                    if (fragment instanceof  FragmentCallBack) {
                        final FragmentCallBack fragmentCallBack = (FragmentCallBack) fragment;
                        fragmentCallBack.callBackHandler();
                    }
                }
                break;
            case SWIPE:
            case MOVE:
                for(Fragment fragment: FRAGMENTS) {
                    if (fragment instanceof SwipeCallback) {
                        final SwipeCallback swipeCallback = (SwipeCallback) fragment;
                        swipeCallback.swipeCallBackHandler();
                    }
                }
                break;
        }
    }

    @Override
    public void fragmentInit(Fragments fragment) {
        switch (fragment.getPrimaryContainer()) {
            case TOP:
                if (APP_STATE.isTopContainerNotEmpty() && APP_STATE.getTopContainerState() == ContainerType.SINGLE) {
                    replaceFragment(fragment);
                } else {
                    addFragment(fragment);
                }
                break;
            case BOTTOM:
                if (APP_STATE.isBottomContainerNotEmpty() && APP_STATE.getBottomContainerState() == ContainerType.SINGLE) {
                    replaceFragment(fragment);
                } else {
                    addFragment(fragment);
                }
                break;
            case MAIN:
                if (APP_STATE.isMainContainerNotEmpty() && APP_STATE.getMainContainerState() == ContainerType.SINGLE) {
                    replaceFragment(fragment);
                } else {
                    addFragment(fragment);
                }
                break;
            case RIGHT:
                if (APP_STATE.isRightContainerNotEmpty() && APP_STATE.getRightContainerState() == ContainerType.SINGLE) {
                    replaceFragment(fragment);
                } else {
                    addFragment(fragment);
                }
                break;
            case LEFT:
                if (APP_STATE.isLeftContainerNotEmpty() && APP_STATE.getLeftContainerState() == ContainerType.SINGLE) {
                    replaceFragment(fragment);
                } else {
                    addFragment(fragment);
                }
                break;
        }
    }

    @Override
    public void removeFragment(Fragments fragment) {
    }

    @Override
    public void addFragment(Fragments fragments) {
        final Fragment fragment = getFragmentClassInstance.getFragmentInstance(fragments);
        FRAGMENTS.add(fragment);
        activity.getSupportFragmentManager()
                .beginTransaction()
                .add(fragments.getPrimaryContainer().getContainer(), fragment)
                .commit();
    }

    @Override
    public void replaceFragment(Fragments fragments) {
    }

    @Override
    public void deleteFragmentList() {
        FRAGMENTS.clear();
    }

    @Override
    public void stepController(Steps step) {
        deleteFragmentList();
        for (Fragments fragment: step.getStepComponents()) {
            fragmentInit(fragment);
        }
    }

    @Override
    public void onStart() {
        APP_STATE.setDisplayMetrics(activity.getResources().getDisplayMetrics());
    }

    @Override
    public void isReady() {

    }

    @Override
    public void onNext() {

    }

    @Override
    public void onDestroy() {

    }

    public void setSwipeListener(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final GestureDetector swipeController = new GestureDetector(view.getContext(), new SwipeController(Fragments.LOGIN));
                swipeController.onTouchEvent(event);
                APP_STATE.getController().startCallBacks();
                return false;
            }
        });
    }
}
