package com.example.rasto.diabetest.Fragments;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by rasto on 3/5/2018.
 */

public class SnackBarComponent {

    private String message;
    private View view;

    public SnackBarComponent(View view, String message) {
        this.view = view;
        this.message = message;
    }

    public void showSnackBar() {
        Snackbar
                .make(this.view, this.message, Snackbar.LENGTH_LONG)
                .show();
    }
}
