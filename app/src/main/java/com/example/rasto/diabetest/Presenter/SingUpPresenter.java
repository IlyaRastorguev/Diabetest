package com.example.rasto.diabetest.Presenter;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rasto.diabetest.Adapters.FieldValidatorAdapter;
import com.example.rasto.diabetest.Constants.Components;
import com.example.rasto.diabetest.Constants.Fragments;
import com.example.rasto.diabetest.Constants.Patterns;
import com.example.rasto.diabetest.Interfaces.PresenterInterface;
import com.example.rasto.diabetest.Interfaces.TextWatcherCallBack;
import com.example.rasto.diabetest.Interfaces.Views.ISingUpView;
import com.example.rasto.diabetest.Model.ApplicationState;
import com.example.rasto.diabetest.Model.Person;
import com.example.rasto.diabetest.R;

/**
 * Created by irastorguev on 18.03.2018.
 */

public class SingUpPresenter extends FieldValidatorAdapter implements TextWatcherCallBack, PresenterInterface, PresenterInterface.ISingUpFragment {

    private final ApplicationState APP_STATE;
    private Person person;

    private ISingUpView singUpView;

    public SingUpPresenter(ISingUpView singUpView) {
        this.singUpView = singUpView;
        this.person = Person.getInstance();
        this.APP_STATE = ApplicationState.getInstance();
    }

    @Override
    public void textWatcherCallback(EditText field, Patterns pattern) {
        if (this.validateField(field.getText().toString(), pattern.getPattern())) {
            singUpView.hideFieldError(field);
        } else {
            //TODO сделать показ сообщений с подсказками при нажатии на кнопку
            singUpView.setFieldError(field);
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
        this.singUpView = null;
    }

    @Override
    public void tryToRegistration() {

    }

    @Override
    public void ifRegistrationIsSuccessfull() {

    }

    @Override
    public void ifRegistrationFailed() {

    }

    @Override
    public void setOnActivateFragmentListener(Button tab) {
        tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (APP_STATE.getCurrentActiveFragment()) {
                    case SING_UP:
                        APP_STATE.setCurrentActiveFragment(Fragments.NULL);
                        break;
                    default:
                        APP_STATE.setCurrentActiveFragment(Fragments.SING_UP);
                        break;
                }
                APP_STATE.getController().startCallBacks();
            }
        });
    }

    @Override
    public boolean isFragmentActive() {
       return APP_STATE.getCurrentActiveFragment() == Fragments.SING_UP;
    }
}
