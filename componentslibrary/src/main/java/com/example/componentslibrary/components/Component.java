package com.example.componentslibrary.components;

import android.view.View;

public interface Component {

    String getComponentType();

    String getComponentState();

    void reportAboutExtEvent();

    View getView();

}
