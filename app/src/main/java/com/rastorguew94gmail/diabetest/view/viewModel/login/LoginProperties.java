package com.rastorguew94gmail.diabetest.view.viewModel.login;

import com.example.components.interfaces.Properties;
import com.example.components.interfaces.PropertyType;
import com.example.components.interfaces.ScreenComponent;
import com.example.components.interfaces.ScreenState;
import com.example.components.types.PropertyTypes;
import com.rastorguew94gmail.diabetest.R;

public class LoginProperties implements Properties {

    @ScreenState(value = "START")
    @ScreenComponent(value = "login_options_button")
    @PropertyType(type = PropertyTypes.TEXT)
    public int getStartOptBtnText() {
        return R.string.login_start_options_button;
    }

    @ScreenState(value = "START")
    @ScreenComponent(value = "login_action_button")
    @PropertyType(type = PropertyTypes.TEXT)
    public int getStartActBntText() {
        return R.string.login_start_action_button;
    }

    @ScreenState(value = "LOGIN")
    @ScreenComponent(value = "login_options_button")
    @PropertyType(type = PropertyTypes.TEXT)
    public int getLoginOptBtnText() {
        return R.string.login_login_options_button;
    }

    @ScreenState(value = "LOGIN")
    @ScreenComponent(value = "login_action_button")
    @PropertyType(type = PropertyTypes.TEXT)
    public int getLoginActBtnText() {
        return R.string.login_login_action_button;
    }

    @ScreenState(value = "SING_UP")
    @ScreenComponent(value = "login_options_button")
    @PropertyType(type = PropertyTypes.TEXT)
    public int getSingUpOptBtnText() {
        return R.string.login_singup_option_button;
    }

    @ScreenState(value = "SING_UP")
    @ScreenComponent(value = "login_action_button")
    @PropertyType(type = PropertyTypes.TEXT)
    public int getSingUpActBtnText() {
        return R.string.login_singup_action_button;
    }

}
