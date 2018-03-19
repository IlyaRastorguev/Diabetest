package com.example.rasto.diabetest.Interfaces;

import android.widget.Button;
import android.widget.EditText;

/**
 * Created by rasto on 3/4/2018.
 */

public interface PresenterInterface {

    interface ILoginFragment {

        void tryToLogin();

        void validateCredentials(EditText email, EditText pass);

        void setOnActivateFragmentListener(Button tab);

    }

    interface ISingUpFragment {

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

    void onStart();

    void isReady();

    void onNext();

    void onDestroy();

}
