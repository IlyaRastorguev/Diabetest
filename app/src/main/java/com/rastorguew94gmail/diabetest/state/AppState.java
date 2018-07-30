package com.rastorguew94gmail.diabetest.state;

public class AppState {
    private static final AppState ourInstance = new AppState();

    public static AppState getInstance() {
        return ourInstance;
    }

    private AppState() {
    }


}
