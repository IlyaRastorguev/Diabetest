package com.example.rasto.diabetest.Presenter;

import android.view.View;
import android.widget.EditText;

import com.example.rasto.diabetest.Adapters.FieldValidatorAdapter;
import com.example.rasto.diabetest.Constants.Components;
import com.example.rasto.diabetest.Constants.Patterns;
import com.example.rasto.diabetest.Constants.StatusCode;
import com.example.rasto.diabetest.Interfaces.IInteractor;
import com.example.rasto.diabetest.Interfaces.PresenterInterface;
import com.example.rasto.diabetest.Interfaces.TextWatcherCallBack;
import com.example.rasto.diabetest.Interfaces.Views.ILoginView;
import com.example.rasto.diabetest.Model.Person;
import com.example.rasto.diabetest.R;

/**
 * Created by rasto on 3/4/2018.
 */

public class LoginPresenter extends FieldValidatorAdapter implements TextWatcherCallBack, PresenterInterface, PresenterInterface.IloginScreen {

    private ILoginView loginView;
    private IInteractor.ILogin login;
    private Person person;

    private boolean noErrors = true;

    public LoginPresenter(ILoginView loginView, IInteractor.ILogin login) {
        this.loginView = loginView;
        this.login = login;
        this.person = Person.getInstance();
    }

    private void setStatus(boolean status) {
        if (!this.noErrors) {
            return;
        } else if (this.noErrors) {
            this.noErrors = status;
        }
    }

    @Override
    public void tryToLogin() {
        if (this.noErrors) {
            StatusCode loginStatus = login.login(person.getEmail(), person.getPassword());
            switch (loginStatus) {
                case SUCCESS:
                    this.ifLoginIsSuccessfully();
                    break;
                default:
                    ifLoginFailed(loginStatus);

            }
        }
    }

    @Override
    public void validateCredentials(EditText email, EditText pass) {
        if (this.validateField(email.getText().toString(), Patterns.EMAIL.getPattern())) {
            this.loginView.hideFieldError(email);
            this.setStatus(true);
        } else {
            this.loginView.setFieldError(email);
            this.setStatus(false);
        }
        if (this.validateField(pass.getText().toString(), Patterns.PASSWORD.getPattern())) {
            this.loginView.hideFieldError(pass);
            this.setStatus(true);
        } else {
            this.loginView.setFieldError(pass);
            this.setStatus(false);
        }
        if (!this.noErrors) {
            this.loginView.showSnackBar(String.format("%S", this.loginView.getResources(R.string.fields_error)));
        }
    }

    @Override
    public void setOnFocusChangeListener(EditText field) {
        field.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    loginView.hideElement(Components.LINEAR_LAYOUT, R.id.main_logo);
                    loginView.showElement(Components.TEXT_VIEW, R.id.second_logo);
                } else {
                    loginView.hideElement(Components.TEXT_VIEW, R.id.second_logo);
                    loginView.showElement(Components.LINEAR_LAYOUT, R.id.main_logo);
                }
            }
        });
    }


    public void ifLoginIsSuccessfully() {
        loginView.goNext();
    }


    public void ifLoginFailed(StatusCode errorCode) {
        String message = null;
        switch (errorCode) {
            case NO_CONNECTION:
                message = String.format(
                        "%S. %S.",
                        this.loginView.getResources(R.string.login_error),
                        this.loginView.getResources(R.string.no_internet_connection)
                );
                break;
            case USER_NOT_EXIST:
                break;
            case CONNECTION_FORBIDDEN:
                break;
            case SERVER_NOT_RESPONSE:
                break;
        }
        if (message != null) {
            loginView.showSnackBar(message);
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void isReady() {

    }

    @Override
    public void onNext() {

    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void textWatcherCallback(EditText field, Patterns pattern) {
        String message = null;

        if (this.validateField(field.getText().toString(), pattern.getPattern())) {
            loginView.hideFieldError(field);
        } else {
            switch (pattern) {
                case EMAIL:
                    message = String.format("%S", this.loginView.getResources(R.string.email_error));
                    break;
                case PASSWORD:
                    message = String.format("%S", this.loginView.getResources(R.string.pass_error));
                    break;
            }
            loginView.setFieldError(field);
        }
        if (message != null) {
            loginView.showSnackBar(message);
        }
    }
}
