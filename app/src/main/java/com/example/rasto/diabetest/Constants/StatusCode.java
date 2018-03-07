package com.example.rasto.diabetest.Constants;

/**
 * Created by rasto on 3/4/2018.
 */

public enum StatusCode {

    USER_NOT_EXIST(1),
    USER_ALLREADY_EXIST(2),
    WRONG_PASSORD_OR_EMAIL(2),
    ERROR_IN_PASSWORD(3),
    ERROR_IN_EMAIL(4),
    ONLY_WORDS(5),
    ONLY_NUMBERS(6),
    OLD_LIMITS(7),
    SEVERAL_FIELD_ERRORS(8),
    CONNECTION_FORBIDDEN(403),
    SERVER_NOT_RESPONSE(404),
    NO_CONNECTION(500),
    SUCCESS(0);

    private int code;

    public int getErrorCode() {
        return code;
    }

    private StatusCode(int value) {
        this.code = value;
    }
}
