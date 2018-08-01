package com.rastorguew94gmail.diabetest.view.viewModel.login;

public enum LoginState {

    START("START"),
    LOGIN("LOGIN"),
    SING_UP("SING_UP");

    private String state;

    LoginState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
