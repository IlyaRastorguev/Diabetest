package com.rastorguew94gmail.diabetest.actions.loginActions;

import com.example.components.interfaces.Action;
import com.example.components.interfaces.ScreenComponent;
import com.example.components.interfaces.ScreenState;

public class Actions implements com.example.components.interfaces.Actions {

    @ScreenState(value = "LOGIN")
    @ScreenComponent(value = "login_action_button")
    public Action  logInAction() {
       return new Action() {
           @Override
           public void doAction() {

           }
       };
    }

    @ScreenState(value = "SING_UP")
    @ScreenComponent(value = "login_action_button")
    public Action singUpAction() {
       return new Action() {
           @Override
           public void doAction() {

           }
       };
    }

    @ScreenState(value = "START")
    @ScreenComponent(value = "login_action_button")
    public Action goToLogin() {
        return new Action() {
            @Override
            public void doAction() {

            }
        };
    }

    @ScreenState(value = "START")
    @ScreenComponent(value = "login_options_button")
    public Action goToSingUp() {
        return new Action() {
            @Override
            public void doAction() {

            }
        };
    }
}
