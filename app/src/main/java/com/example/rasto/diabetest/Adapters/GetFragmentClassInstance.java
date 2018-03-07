package com.example.rasto.diabetest.Adapters;


import android.support.v4.app.Fragment;

import com.example.rasto.diabetest.Constants.Screens;
import com.example.rasto.diabetest.Fragments.LoginFragment;

/**
 * Created by rasto on 3/4/2018.
 */

public class GetFragmentClassInstance {

    public Fragment getFragmentInstance(Screens screen) {
        switch (screen) {
            case LOGIN:
                return new LoginFragment();
        }
        return null;
    }
}
