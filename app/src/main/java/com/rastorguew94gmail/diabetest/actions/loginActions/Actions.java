package com.rastorguew94gmail.diabetest.actions.loginActions;

import com.example.components.interfaces.Action;
import com.example.components.interfaces.ScreenComponent;
import com.example.components.interfaces.ScreenState;
import com.rastorguew94gmail.diabetest.actions.Status;

public class Actions implements Action {

    @ScreenState("LOGIN")
    @ScreenComponent("login_action")
    public Status logInAction() {
        return Status.OK;
    }

    @ScreenState("SING_UP")
    @ScreenComponent("login_action")
    public Status singUpAction() {
        return Status.OK;
    }

    @ScreenState("START")
    @ScreenComponent("login_action")
    public void goToLogin() {

    }

    @ScreenState("START")
    @ScreenComponent("login_options_action")
    public void goToSingUp() {

    }
}
