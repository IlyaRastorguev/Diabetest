package com.example.rasto.diabetest.Constants;

/**
 * Created by irastorguev on 26.03.2018.
 */

public enum Axis {
    LAST(0f, 0f),
    CURRENT(0f, 0f);

    private float x;
    private float y;

    Axis (float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
