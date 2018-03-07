package com.example.rasto.diabetest.Constants;

import com.example.rasto.diabetest.R;

/**
 * Created by rasto on 3/4/2018.
 */

public enum Screens {

    LOGIN(R.layout.login_fragment);

    private int fragmentId;

    public int getFragmentId() {
        return fragmentId;
    }

    private Screens(int value) {
        this.fragmentId = value;
    }
}
