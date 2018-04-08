package com.example.rasto.diabetest.Presenter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rasto.diabetest.Adapters.FieldValidatorAdapter;
import com.example.rasto.diabetest.Adapters.SwipeController;
import com.example.rasto.diabetest.Constants.Components;
import com.example.rasto.diabetest.Constants.EventDirection;
import com.example.rasto.diabetest.Constants.EventTypes;
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

public class SingUpPresenter extends FieldValidatorAdapter implements PresenterInterface, PresenterInterface.ISingUpFragment {

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
        singUpView.getView().setY(APP_STATE.getDisplayMetrics().heightPixels - 96 * APP_STATE.getDisplayMetrics().density);
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
                switch (APP_STATE.getEventType()) {
                    case SWIPE:
                        if (APP_STATE.getEventDirection() == EventDirection.TOP) {
                            APP_STATE.setCurrentActiveFragment(Fragments.SING_UP);
                        } else {
                            APP_STATE.setCurrentActiveFragment(Fragments.NULL);
                        }
                        APP_STATE.setEventType(EventTypes.CLICK);
                        break;
                    case CLICK:
                    case NULL:
                        APP_STATE.setEventType(EventTypes.CLICK);
                        if (APP_STATE.getCurrentActiveFragment() == Fragments.SING_UP) {
                            APP_STATE.setCurrentActiveFragment(Fragments.NULL);
                        } else {
                            APP_STATE.setCurrentActiveFragment(Fragments.SING_UP);
                        }
                        APP_STATE.getController().startCallBacks();
                        break;
                }
            }
        });
    }

    @Override
    public boolean isFragmentActive() {
       return APP_STATE.getCurrentActiveFragment() == Fragments.SING_UP;
    }

    @Override
    public void setSwipeListener(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final GestureDetector swipeController = new GestureDetector(view.getContext(), new SwipeController(Fragments.SING_UP));
                swipeController.onTouchEvent(event);
                if (event.getHistorySize() > 0 && event.getAction() == MotionEvent.ACTION_MOVE) {
                    APP_STATE.setEventType(EventTypes.SWIPE);
                    if (event.getHistoricalAxisValue(1, 0 ) - event.getHistoricalAxisValue(1, event.getHistorySize() - 1 ) > 0) {
                        APP_STATE.setEventDirection(EventDirection.TOP);
                    } else APP_STATE.setEventDirection(EventDirection.DOWN);
                    for (int index = 0; index < event.getHistorySize(); index++ ) {
                        if (index > 0) {
                            APP_STATE.setLastPoint(event.getHistoricalAxisValue(0, index - 1), event.getHistoricalAxisValue(1, index - 1));
                            APP_STATE.setCurrentPoint(event.getHistoricalAxisValue(0, index), event.getHistoricalAxisValue(1, index));
                        } else {
                            APP_STATE.setLastPoint(event.getHistoricalAxisValue(0, index), event.getHistoricalAxisValue(1, index));
                            APP_STATE.setCurrentPoint(event.getHistoricalAxisValue(0, index), event.getHistoricalAxisValue(1, index));
                        }
                        APP_STATE.getController().startCallBacks();
                    }
                    APP_STATE.setLastPoint(0f, 0f);
                    APP_STATE.setCurrentPoint(0f, 0f);
                    return true;
                }
                return false;
            }
        });
    }

}
