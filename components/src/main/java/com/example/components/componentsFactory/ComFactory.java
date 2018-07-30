package com.example.components.componentsFactory;

import com.example.components.interfaces.Action;
import com.example.components.interfaces.Subscriber;
import com.example.components.props.ComponentProperties;

import java.util.List;

public class ComFactory<T> {

    ComponentProperties<T> componentProperties = new ComponentProperties<>();

    public ComFactory<T> setTextValue(String value) {
        componentProperties.setTextValue(value);
        return this;
    }

    public ComFactory<T> setLayoutId(int id) {
        componentProperties.setLayoutId(id);
        return this;
    }

    public ComFactory<T> setWidth(int width) {
        componentProperties.setWidth(width);
        return this;
    }


    public ComFactory<T> setHeight(int height) {
        componentProperties.setHeight(height);
        return this;
    }

    public ComFactory<T> setAction(Action action) {
        componentProperties.setAction(action);
        return this;
    }

    public ComFactory<T> setSubscribers(List<Subscriber> subscribers) {
        componentProperties.setSubscribers(subscribers);
        return this;
    }

    public ComFactory<T> setBackgroundId(int backgroundId) {
        componentProperties.setBackgroundId(backgroundId);
        return this;
    }

    public ComFactory<T> setCoordinates(Integer x, Integer y) {
        if (x != null) componentProperties.setPositionX(x);
        if (y != null) componentProperties.setPositionY(y);
        return this;
    }

    public ComFactory<T> setEventType(String eventType) {
        componentProperties.setEventType(eventType);
        return this;
    }

}
