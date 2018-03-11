package com.example.rasto.diabetest.Interfaces;

import android.widget.EditText;

/**
 * Created by rasto on 3/4/2018.
 */

public interface PresenterInterface {

    interface IloginScreen {

        void tryToLogin();

        void validateCredentials(EditText email, EditText pass);

        void setOnFocusChangeListener(EditText field);

    }

    interface IRegistrationScreen {

        void tryToRegistration();

        void ifRegistrationIsSuccessfull();

        void ifRegistrationFaild();
    }

    interface ITopBar {

        void stepBack();

        void stepForward();

        void setCurrentStep();
    }

    void onStart();

    void isReady();

    void onNext();

    void onDestroy();

}
