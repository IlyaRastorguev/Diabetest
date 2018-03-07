package com.example.rasto.diabetest.Adapters;

import com.example.rasto.diabetest.Interfaces.IFieldsValidator;

/**
 * Created by rasto on 3/4/2018.
 */

public class FieldValidatorAdapter implements IFieldsValidator {


    @Override
    public boolean validateField(String value, String pattern) {
        final boolean result = value.matches(pattern);
        return result;
    }
}
