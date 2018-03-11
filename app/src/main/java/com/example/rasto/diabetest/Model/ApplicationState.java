package com.example.rasto.diabetest.Model;

import com.example.rasto.diabetest.Constants.Screens;

/**
 * Created by rasto on 3/10/2018.
 */

public class ApplicationState {

    private static ApplicationState instance;

    private Screens currentScreen;

    private ApplicationState() {
    }

    public static synchronized ApplicationState getInstance() {
        if (instance == null) {
            instance = new ApplicationState();
        }
        return instance;
    }

    public Screens getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(Screens currentScreen) {
        this.currentScreen = currentScreen;
    }
}
