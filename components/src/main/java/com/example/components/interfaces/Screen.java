package com.example.components.interfaces;

import androidx.fragment.app.Fragment;

public interface Screen {

    Fragment getScreen();

    void setCurrentState();

    String getCurrentState();
}
