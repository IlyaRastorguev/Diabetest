package com.example.components.handlers;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.components.componentsFactory.ComFactory;
import com.example.components.interfaces.Actions;
import com.example.components.interfaces.Properties;
import com.example.components.interfaces.PropertyType;
import com.example.components.interfaces.Screen;
import com.example.components.interfaces.ScreenComponent;
import com.example.components.interfaces.ScreenState;
import com.example.components.types.PropertyTypes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BasicHandler extends Handler {

    private Actions actions;

    private Screen screen;

    private View view;

    private Properties props;

    public BasicHandler(Actions actions, Screen screen, Properties props) {
        this.actions = actions;
        this.screen = screen;
        this.props = props;
    }

    public void findComponents(ViewGroup viewGroup) {
        View view = null;
        for (int i = 0; i <= viewGroup.getChildCount(); i++) {
            try {
                view = viewGroup.getChildAt(i);
                ViewGroup innerViewGroup = (ViewGroup) view;
                findComponents(innerViewGroup);
            } catch (ClassCastException e) {
                initComponent(view);
            }
        }
    }

    private void initComponent(View view) {
        this.view = view;
        ComFactory.get().setView(view);
        initActions();
        initProps();
    }

    private void initActions() {
        Class clazz = actions.getClass();
        String viewId = String.format("%s", view.getId());
        for (Method method : clazz.getMethods()) {
            if (compareScreenState(screen.getCurrentState(), method)
                    && compareScreenComponent(viewId, method)) {
                try {
                    ComFactory.get().setAction(method.invoke(actions));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    Log.e("", "", e);
                }
            }
        }
    }

    private void initProps() {
        Class clazz = props.getClass();
        String viewId = String.format("%s", view.getId());
        for (Method method : clazz.getMethods()) {
            if (compareScreenState(screen.getCurrentState(), method)
                    && compareScreenComponent(viewId, method)) {
                setProperty(method.getAnnotation(PropertyType.class).type(), method);
            }
        }
    }

    private void setProperty(PropertyTypes type, Method method) {
        try {
            switch (type) {
                case TEXT:
                    ComFactory.get().setTextValue((String) method.invoke(props));
                    break;
                case WIDTH:
                    ComFactory.get().setWidth((int) method.invoke(props));
                    break;
                case HEIGHT:
                    ComFactory.get().setHeight((int) method.invoke(props));
                    break;
                case FOCUS:
                    ComFactory.get().setNeedFocus((Boolean) method.invoke(props));
                    break;
                case VISIBILITY:
                    ComFactory.get().setVisibility((int) method.invoke(props));
                    break;
                case BACKGROUND:
                    ComFactory.get().setBackgroundId((int) method.invoke(props));
                    break;
                case NONE:
                    break;
                default:
            }
        } catch (IllegalAccessException | InvocationTargetException | ClassCastException e) {
            Log.e("", "", e);
        }

    }

    private boolean compareScreenState(String currentState, Method method) {
        return method.getAnnotation(ScreenState.class).value().equals(currentState);
    }

    private boolean compareScreenComponent(String component, Method method) {
        return method.getAnnotation(ScreenComponent.class).value().equals(component);
    }
}
