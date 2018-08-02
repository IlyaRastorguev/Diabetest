package com.rastorguew94gmail.diabetest.view.viewModel.login;

import com.example.components.store.Store;
import com.rastorguew94gmail.diabetest.R;
import com.rastorguew94gmail.diabetest.actions.loginActions.Actions;
import com.example.components.interfaces.Screen;

import androidx.fragment.app.Fragment;

public class LoginScreen implements Screen {

    private Store store = Store.getInstance();

    private int layoutId = R.id.login_screen;

    private static final Actions LOGIN_ACTIONS = new Actions();

    private LoginState currentState = LoginState.START;

    @Override
    public Fragment getScreen() {
        return null;
    }

    @Override
    public void setCurrentState() {

    }

    @Override
    public String getCurrentState() {
        return null;
    }

}
