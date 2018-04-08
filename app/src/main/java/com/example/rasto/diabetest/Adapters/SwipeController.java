package com.example.rasto.diabetest.Adapters;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.rasto.diabetest.Constants.EventTypes;
import com.example.rasto.diabetest.Constants.Fragments;
import com.example.rasto.diabetest.Model.ApplicationState;

/**
 * Created by irastorguev on 25.03.2018.
 */

public class SwipeController extends GestureDetector.SimpleOnGestureListener {

    private Fragments fragment;
    private ApplicationState APP_STATE;

    private MotionEvent startEvent;

    public SwipeController(Fragments fragment) {
        this.fragment = fragment;
        APP_STATE = ApplicationState.getInstance();
    }

    @Override
    public boolean onDown(MotionEvent e) {
        this.startEvent = e;
        return super.onDown(e);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        APP_STATE.setCurrentActiveFragment(fragment);
        APP_STATE.setEventType(EventTypes.MOVE);
        return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return super.onSingleTapUp(e);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return super.onSingleTapConfirmed(e);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    @Override
    public void onLongPress(MotionEvent e) {
        super.onLongPress(e);
    }

    @Override
    public void onShowPress(MotionEvent e) {
        super.onShowPress(e);
    }
}
