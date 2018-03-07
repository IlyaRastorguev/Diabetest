package com.example.rasto.diabetest.Adapters;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.rasto.diabetest.Constants.Patterns;
import com.example.rasto.diabetest.Interfaces.TextWatcherCallBack;

/**
 * Created by rasto on 3/4/2018.
 */

public class TextWatcherAdapter implements TextWatcher {

    private TextWatcherCallBack textWatcherCallBack;
    private EditText field;
    private Patterns pattern;

    public TextWatcherAdapter(
            Object textWatcherCallBack,
            EditText field,
            Patterns pattern
    ) {
        this.textWatcherCallBack = (TextWatcherCallBack) textWatcherCallBack;
        this.field = field;
        this.pattern = pattern;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        textWatcherCallBack.textWatcherCallback(this.field, this.pattern);
    }
}