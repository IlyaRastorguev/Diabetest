package com.example.rasto.diabetest.Model;

import android.util.DisplayMetrics;
import android.view.MotionEvent;

import com.example.rasto.diabetest.Constants.Axis;
import com.example.rasto.diabetest.Constants.ContainerType;
import com.example.rasto.diabetest.Constants.EventDirection;
import com.example.rasto.diabetest.Constants.EventTypes;
import com.example.rasto.diabetest.Constants.Fragments;
import com.example.rasto.diabetest.Constants.Steps;
import com.example.rasto.diabetest.Interfaces.Views.ActivityHubView;

/**
 * Created by rasto on 3/10/2018.
 */

public class ApplicationState {

    private static ApplicationState instance;

    private Fragments currentActiveFragment;

    private EventTypes eventType = EventTypes.NULL;
    private EventDirection eventDirection = EventDirection.NULL;

    private Axis lastPoint = Axis.LAST;
    private Axis currentPoint = Axis.CURRENT;

    private DisplayMetrics displayMetrics;

    private Steps currentAppStep;

    private boolean topContainerNotEmpty = false;
    private boolean mainContainerNotEmpty = false;
    private boolean bottomContainerNotEmpty = false;
    private boolean leftContainerNotEmpty = false;
    private boolean rightContainerNotEmpty = false;

    private ContainerType topContainerState = ContainerType.SINGLE;
    private ContainerType mainContainerState = ContainerType.SINGLE;
    private ContainerType bottomContainerState = ContainerType.SINGLE;
    private ContainerType leftContainerState = ContainerType.SINGLE;
    private ContainerType rightContainerState = ContainerType.SINGLE;

    private ActivityHubView controller;

    private ApplicationState() {
        this.currentActiveFragment = Fragments.NULL;
        this.currentAppStep = Steps.NULL;
        this.eventType = EventTypes.NULL;
    }

    public static synchronized ApplicationState getInstance() {
        if (instance == null) {
            instance = new ApplicationState();
        }
        return instance;
    }

    public Fragments getCurrentActiveFragment() {
        return currentActiveFragment;
    }

    public void setCurrentActiveFragment(Fragments currentActiveFragment) {
        this.currentActiveFragment = currentActiveFragment;
    }

    public Steps getCurrentAppStep() {
        return currentAppStep;
    }

    public void setCurrentAppStep(Steps currentAppStep) {
        this.currentAppStep = currentAppStep;
    }

    public boolean isTopContainerNotEmpty() {
        return topContainerNotEmpty;
    }

    public void setTopContainerNotEmpty(boolean topContainerNotEmpty) {
        this.topContainerNotEmpty = topContainerNotEmpty;
    }

    public boolean isMainContainerNotEmpty() {
        return mainContainerNotEmpty;
    }

    public void setMainContainerNotEmpty(boolean mainContainerNotEmpty) {
        this.mainContainerNotEmpty = mainContainerNotEmpty;
    }

    public boolean isBottomContainerNotEmpty() {
        return bottomContainerNotEmpty;
    }

    public void setBottomContainerNotEmpty(boolean bottomContainerNotEmpty) {
        this.bottomContainerNotEmpty = bottomContainerNotEmpty;
    }

    public boolean isLeftContainerNotEmpty() {
        return leftContainerNotEmpty;
    }

    public void setLeftContainerNotEmpty(boolean leftContainerNotEmpty) {
        this.leftContainerNotEmpty = leftContainerNotEmpty;
    }

    public boolean isRightContainerNotEmpty() {
        return rightContainerNotEmpty;
    }

    public void setRightContainerNotEmpty(boolean rightContainerNotEmpty) {
        this.rightContainerNotEmpty = rightContainerNotEmpty;
    }

    public ContainerType getTopContainerState() {
        return topContainerState;
    }

    public void setTopContainerState(ContainerType topContainerState) {
        this.topContainerState = topContainerState;
    }

    public ContainerType getMainContainerState() {
        return mainContainerState;
    }

    public void setMainContainerState(ContainerType mainContainerState) {
        this.mainContainerState = mainContainerState;
    }

    public ContainerType getBottomContainerState() {
        return bottomContainerState;
    }

    public void setBottomContainerState(ContainerType bottomContainerState) {
        this.bottomContainerState = bottomContainerState;
    }

    public ContainerType getLeftContainerState() {
        return leftContainerState;
    }

    public void setLeftContainerState(ContainerType leftContainerState) {
        this.leftContainerState = leftContainerState;
    }

    public ContainerType getRightContainerState() {
        return rightContainerState;
    }

    public void setRightContainerState(ContainerType rightContainerState) {
        this.rightContainerState = rightContainerState;
    }

    public ActivityHubView getController() {
        return controller;
    }

    public void setController(ActivityHubView controller) {
        this.controller = controller;
    }

    public EventTypes getEventType() {
        return eventType;
    }

    public void setEventType(EventTypes eventType) {
        this.eventType = eventType;
    }

    public Axis getLastPoint() {
        return lastPoint;
    }

    public void setLastPoint(float x, float y) {
        this.lastPoint.setX(x);
        this.lastPoint.setY(y);
    }

    public Axis getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(float x, float y) {
        this.currentPoint.setX(x);
        this.currentPoint.setY(y);
    }

    public EventDirection getEventDirection() {
        return eventDirection;
    }

    public void setEventDirection(EventDirection eventDirection) {
        this.eventDirection = eventDirection;
    }

    public DisplayMetrics getDisplayMetrics() {
        return displayMetrics;
    }

    public void setDisplayMetrics(DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
    }
}
