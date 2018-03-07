package com.example.rasto.diabetest.Interactors;

import android.util.Base64;

import com.example.rasto.diabetest.Constants.StatusCode;
import com.example.rasto.diabetest.Interfaces.IInteractor;


/**
 * Created by rasto on 3/5/2018.
 */

public class LoginInteractor implements IInteractor.ILogin {

    @Override
    public StatusCode login(String email, Base64 password) {
        return StatusCode.SUCCESS;
    }

}
