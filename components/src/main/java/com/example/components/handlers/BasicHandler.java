package com.example.components.handlers;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;

import com.example.components.interfaces.Action;
import com.example.components.interfaces.Screen;
import com.example.components.interfaces.ScreenState;

import java.lang.reflect.Method;

public class BasicHandler extends Handler {

    private Action action;

    private Screen screen;

    public BasicHandler(Action action, Screen screen) {
        this.action = action;
    }

    public void findComponents(ViewGroup viewGroup) {
        View view = null;
        for (int i = 0; i <= viewGroup.getChildCount(); i++) {
            try {
                view = viewGroup.getChildAt(i);
                ViewGroup innerViewGroup = (ViewGroup) view;
                findComponents(innerViewGroup);
            }catch (ClassCastException e) {
                initComponent(view);
            }
        }
    }

    private void initComponent(View view) {
        Class clazz = action.getClass();
        for (Method method: clazz.getMethods()) {
            if (method.getAnnotation(ScreenState.class).value().equals(screen.getCurrentState())) {
                String viewId = String.format("%i", view.getId());
            }
        }
    }
}
