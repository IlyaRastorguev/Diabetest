package com.example.components.interfaces;

import com.example.components.types.PropertyTypes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyType {
    public PropertyTypes type() default PropertyTypes.NONE;
}
