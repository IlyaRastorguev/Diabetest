package com.example.rasto.diabetest.Constants;

import com.example.rasto.diabetest.R;

/**
 * Created by rasto on 3/4/2018.
 */

public enum Fragments {

    TOP_BAR(R.layout.top_bar_fragment),
    LOGIN(R.layout.login_fragment),
    SING_UP(R.layout.sing_up_fragment),
    NULL(0);

    private int fragmentId;

    public int getFragmentId() {
        return fragmentId;
    }

    private Fragments(int value) {
        this.fragmentId = value;
    }
}
