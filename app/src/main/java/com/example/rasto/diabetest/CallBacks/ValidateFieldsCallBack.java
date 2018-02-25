package com.example.rasto.diabetest.CallBacks;

import android.widget.EditText;

import com.example.rasto.diabetest.Interfaces.IValidateFields;

import java.util.HashMap;

/**
 * Created by rasto on 2/25/2018.
 */

public class ValidateFieldsCallBack implements IValidateFields {

    private boolean result;

    @Override
    public void isFieldValid(String value, String pattern) {
        if (value != null) {
            result = value.matches(pattern);
        }
    }

    @Override
    public boolean getResult() {
        return result;
    }
}
