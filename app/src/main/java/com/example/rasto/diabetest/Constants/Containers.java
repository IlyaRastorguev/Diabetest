package com.example.rasto.diabetest.Constants;

import com.example.rasto.diabetest.R;

/**
 * Created by rasto on 3/4/2018.
 */

public enum Containers {

    TOP(R.id.top_container),
    MAIN(R.id.main_container),
    BOTTOM(R.id.bottom_container),
    LEFT(R.id.left_container),
    RIGHT(R.id.right_container);

    private int container;

    public int getContainer() {
        return container;
    }

    private Containers(int value) {
        this.container = value;
    }
}
