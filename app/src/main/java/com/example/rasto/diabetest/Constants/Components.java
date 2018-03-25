package com.example.rasto.diabetest.Constants;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by rasto on 3/11/2018.
 */

public enum Components {

    EDIT_TEXT(EditText.class),
    TEXT_VIEW(TextView.class),
    BUTTON(Button.class),
    VIEW(View.class),
    LINEAR_LAYOUT(LinearLayout.class),
    RELATIVE_LAYOUT(RelativeLayout.class),
    SCROLL_VIEW(ScrollView.class),
    SPINNER(Spinner.class);

    private Object component;

    private Components(Object component) {
        this.component = component;
    }

    public Object getComponent() {
        return component;
    }
}
