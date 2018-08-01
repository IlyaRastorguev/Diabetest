package com.rastorguew94gmail.diabetest.actions.loginActions;

import com.example.components.interfaces.ScreenComponent;
import com.example.components.interfaces.Screen;
import com.example.components.interfaces.ScreenState;
import com.rastorguew94gmail.diabetest.actions.Status;

public class Actions {

    @Screen("LOGIN")
    @ScreenState("LOGIN")
    @ScreenComponent("login_action")
    public Status logInAction() {
        return Status.OK;
    }

    @Screen("LOGIN")
    @ScreenState("SING_UP")
    @ScreenComponent("login_action")
    public Status singUpAction() {
        return Status.OK;
    }

    @Screen("LOGIN")
    @ScreenState("START")
    @ScreenComponent("login_action")
    public void goToLogin() {

    }

    @Screen("LOGIN")
    @ScreenState("START")
    @ScreenComponent("login_options_action")
    public void goToSingUp() {

    }
}
