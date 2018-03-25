package com.example.rasto.diabetest.Constants;

import com.example.rasto.diabetest.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by irastorguev on 19.03.2018.
 */

public enum Steps {
    NULL(),
    LOGIN(Fragments.LOGIN, Fragments.SING_UP),
    HOME();

    private List<Fragments> stepComponents;

    Steps(Fragments... stepComponents) {
        this.stepComponents = Arrays.asList(stepComponents);
    }

    public List<Fragments> getStepComponents() {
        return stepComponents;
    }
}
