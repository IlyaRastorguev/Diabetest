package com.example.rasto.diabetest.Adapters;


import android.support.v4.app.Fragment;

import com.example.rasto.diabetest.Constants.Fragments;
import com.example.rasto.diabetest.Fragments.ImageFragment;
import com.example.rasto.diabetest.Fragments.LoginFragment;
import com.example.rasto.diabetest.Fragments.SingUpFragment;
import com.example.rasto.diabetest.Fragments.TopBarFragment;

/**
 * Created by rasto on 3/4/2018.
 */

public class GetFragmentClassInstance {

    public Fragment getFragmentInstance(Fragments screen) {
        switch (screen) {
            case SING_UP_IMAGE:
                return new ImageFragment();
            case LOGIN:
                return new LoginFragment();
            case SING_UP:
                return new SingUpFragment();
            case TOP_BAR:
                return new TopBarFragment();
        }
        return null;
    }
}
