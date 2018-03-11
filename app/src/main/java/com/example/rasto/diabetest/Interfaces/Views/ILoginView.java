package com.example.rasto.diabetest.Interfaces.Views;

import android.widget.EditText;

/**
 * Created by rasto on 3/4/2018.
 */

public interface ILoginView extends BasicView {

    void setFieldError(EditText fieldError);

    void hideFieldError(EditText fieldError);

    void showSnackBar(String message);

    String getResources(int id);

    void goNext();
}
