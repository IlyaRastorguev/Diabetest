package com.example.rasto.diabetest.Interfaces;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rasto.diabetest.Constants.Fragments;
import com.example.rasto.diabetest.Constants.Steps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rasto on 3/4/2018.
 */

public interface PresenterInterface {

    interface IBasicFragment {

        boolean isFragmentActive();
    }

    interface ILoginFragment extends IBasicFragment {

        void tryToLogin();

        void validateCredentials(EditText email, EditText pass);

        void setOnActivateFragmentListener(Button tab);

    }

    interface ISingUpFragment extends IBasicFragment {

        void tryToRegistration();

        void ifRegistrationIsSuccessfull();

        void ifRegistrationFailed();

        void setOnActivateFragmentListener(Button tab);
    }

    interface ITopBar {

        void stepBack();

        void stepForward();

        void setCurrentStep();
    }

    interface IActivityHub {

        static final List<Fragment> FRAGMENTS = new ArrayList<>();

        void fragmentsCallBack();

        void fragmentInit(Fragments fragment);

        void removeFragment(Fragments fragment);

        void addFragment(Fragments fragments);

        void replaceFragment(Fragments fragments);

        void deleteFragmentList();

        void stepController(Steps step);

        void setSwipeListener(View view);

    }

    void onStart();

    void isReady();

    void onNext();

    void onDestroy();

}
