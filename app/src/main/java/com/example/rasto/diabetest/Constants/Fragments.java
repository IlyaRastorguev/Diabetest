package com.example.rasto.diabetest.Constants;

import com.example.rasto.diabetest.R;

/**
 * Created by rasto on 3/4/2018.
 */

public enum Fragments {

    NULL(0, null),
    TOP_BAR(R.layout.top_bar_fragment, Containers.TOP),
    LOGIN(R.layout.login_fragment, Containers.MAIN),
    SING_UP(R.layout.sing_up_fragment, Containers.MAIN);

    private int fragmentId;
    private Containers primaryContainer;

    public int getFragmentId() {
        return fragmentId;
    }

    public Containers getPrimaryContainer() {
        return primaryContainer;
    }

    Fragments(int value, Containers primaryContainer) {
        this.fragmentId = value;
        this.primaryContainer = primaryContainer;
    }
}
