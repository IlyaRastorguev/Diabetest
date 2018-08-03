package com.example.components.props;

import android.view.View;

import com.example.components.interfaces.Action;
import com.example.components.interfaces.Subscriber;

import java.util.List;

public class ComponentProperties {

    private View component;

    private Class componentClass;

    private String textValue;

    private int layoutId;

    private int width;

    private int height;

    private Action action;

    private List<Subscriber> subscribers;

    private int backgroundId;

    private int positionX;

    private int positionY;

    private String eventType;

    private int visibility;

    private Boolean needFocus = false;

    public View getComponent() {
        return component;
    }

    public void setComponent(View component) {
        this.component = component;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public int getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Class getComponentClass() {
        return componentClass;
    }

    public void setComponentClass(Class componentClass) {
        this.componentClass = componentClass;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Boolean getNeedFocus() {
        return needFocus;
    }

    public void setNeedFocus(Boolean needFocus) {
        this.needFocus = needFocus;
    }
}
