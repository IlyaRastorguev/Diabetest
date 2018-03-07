package com.example.rasto.diabetest.Interfaces;

import android.util.Base64;

import com.example.rasto.diabetest.Constants.StatusCode;

/**
 * Created by rasto on 3/4/2018.
 */

public interface IInteractor {

    interface ILogin {

        StatusCode login(String email, Base64 password);

    }

    interface IRegistration {

        void registration();

        void validateCredentials(IFieldsValidator validator);
    }

    interface IReadyToNextStep {

        boolean hasNoErrors();

        void goToNext();
    }
}
