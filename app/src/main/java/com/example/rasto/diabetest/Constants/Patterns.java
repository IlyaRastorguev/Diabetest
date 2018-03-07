package com.example.rasto.diabetest.Constants;

/**
 * Created by rasto on 3/4/2018.
 */

public enum Patterns {
    EMAIL("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$"),
    PASSWORD("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");

    private String pattern;

    public String getPattern() {
        return pattern;
    }

    private Patterns(String value) {
        this.pattern = value;
    }
}
