package com.example.rasto.diabetest.Constants;

import com.example.rasto.diabetest.R;

/**
 * Created by irastorguev on 19.03.2018.
 */

public enum Steps {
    NULL(0),
    START(R.string.login_step),
    HOME(1);

    private int step;

    private Steps(int step) {
        this.step = step;
    }

    public int getStep() {
        return step;
    }
}
