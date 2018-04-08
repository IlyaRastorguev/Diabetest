package com.example.rasto.diabetest.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.rasto.diabetest.Constants.Components;
import com.example.rasto.diabetest.Interfaces.FragmentCallBack;
import com.example.rasto.diabetest.Interfaces.SwipeCallback;
import com.example.rasto.diabetest.Interfaces.Views.ISingUpView;
import com.example.rasto.diabetest.Model.ApplicationState;
import com.example.rasto.diabetest.Presenter.SingUpPresenter;
import com.example.rasto.diabetest.R;
import static com.example.rasto.diabetest.Constants.EventDirection.*;
import static com.example.rasto.diabetest.Constants.Fragments.*;

/**
 * Created by irastorguev on 18.03.2018.
 */

public class SingUpFragment extends Fragment implements ISingUpView, FragmentCallBack, SwipeCallback {

    private EditText email;
    private EditText pass;
    private EditText firstName;
    private EditText middleName;
    private EditText lastName;
    private EditText age;
    private EditText weight;

    private Spinner sex;
    private Spinner diabetes;

    private final ApplicationState APP_STATE = ApplicationState.getInstance();


    private Button activateSingUpTab;

    private SingUpPresenter singUpPresenter;

    private View view;

    private void componentsInit() {
        this.email = (EditText) view.findViewById(R.id.email);
        this.pass = (EditText) view.findViewById(R.id.pass);
        this.firstName = (EditText) view.findViewById(R.id.first_name);
        this.lastName = (EditText) view.findViewById(R.id.last_name);
        this.middleName = (EditText) view.findViewById(R.id.middle_name);
        this.age = (EditText) view.findViewById(R.id.age);
        this.weight = (EditText) view.findViewById(R.id.weight);
        this.sex = (Spinner) view.findViewById(R.id.sex);
        this.diabetes = (Spinner) view.findViewById(R.id.diabetes);
        this.activateSingUpTab = (Button) view.findViewById(R.id.sing_up_tab);
        this.singUpPresenter.setOnActivateFragmentListener(activateSingUpTab);
        this.singUpPresenter.setSwipeListener(activateSingUpTab);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.sing_up_fragment, container, false);
        this.singUpPresenter = new SingUpPresenter(this);
        this.singUpPresenter.onStart();
        componentsInit();
        return this.view;
    }

    @Override
    public void setFieldError(EditText fieldError) {

    }

    @Override
    public void hideFieldError(EditText fieldError) {

    }

    @Override
    public void showSnackBar(String message) {

    }

    @Override
    public String getResources(int id) {
        return null;
    }

    @Override
    public void goNext() {

    }

    @Override
    public void hideElement(Components elementType, int id) {
        switch (elementType) {
            case RELATIVE_LAYOUT:
                final RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(id);
                relativeLayout.setVisibility(View.GONE);
                break;
            case TEXT_VIEW:
                final TextView textView = (TextView) view.findViewById(id);
                textView.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void showElement(Components elementType, int id) {
        switch (elementType) {
            case RELATIVE_LAYOUT:
                final RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(id);
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case TEXT_VIEW:
                final TextView textView = (TextView) view.findViewById(id);
                textView.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void callBackHandler() {
        switch (APP_STATE.getCurrentActiveFragment()) {
            case LOGIN:
                view.setTranslationY(APP_STATE.getDisplayMetrics().heightPixels - 96 * APP_STATE.getDisplayMetrics().density);
                break;
            case SING_UP:
                view.setTranslationY(0);
                break;
            case NULL:
                view.setTranslationY(APP_STATE.getDisplayMetrics().heightPixels - 96 * APP_STATE.getDisplayMetrics().density);
                break;
        }
    }

    @Override
    public void swipeCallBackHandler() {
        switch (APP_STATE.getCurrentActiveFragment()) {
            case SING_UP:
                if (APP_STATE.getLastPoint() != null && APP_STATE.getCurrentPoint() != null) {
                    final float moveDistance = Math.abs(APP_STATE.getLastPoint().getY() - APP_STATE.getCurrentPoint().getY());
                    switch (APP_STATE.getEventDirection()) {
                        case TOP:
                            if ((APP_STATE.getDisplayMetrics().heightPixels - (Math.round(view.getY() - moveDistance * 2))) / APP_STATE.getDisplayMetrics().density > 240) {
                                view.setTranslationY(0);
                            } else view.setTranslationY(Math.round(view.getY() - moveDistance * 2));
                            break;
                        case DOWN:
                            if ((APP_STATE.getDisplayMetrics().heightPixels - (Math.round(view.getY() + moveDistance * 2))) / APP_STATE.getDisplayMetrics().density < 320) {
                                view.setTranslationY(APP_STATE.getDisplayMetrics().heightPixels - 96 * APP_STATE.getDisplayMetrics().density);
                            } else view.setTranslationY(Math.round(view.getY() + moveDistance * 2));
                            break;
                    }
                }
                break;
            case LOGIN:
                if (APP_STATE.getLastPoint() != null && APP_STATE.getCurrentPoint() != null) {
                    final float moveDistance = Math.abs(APP_STATE.getLastPoint().getY() - APP_STATE.getCurrentPoint().getY());
                    switch (APP_STATE.getEventDirection()) {
                        case TOP:
                            if ((APP_STATE.getDisplayMetrics().heightPixels - (Math.round(view.getY() + moveDistance * 2))) / APP_STATE.getDisplayMetrics().density < 320) {
                                view.setTranslationY(APP_STATE.getDisplayMetrics().heightPixels - 96 * APP_STATE.getDisplayMetrics().density);
                            } else view.setTranslationY(Math.round(view.getY() + moveDistance * 2));
                            break;
                        case DOWN:
                            view.setTranslationY(APP_STATE.getDisplayMetrics().heightPixels - 96 * APP_STATE.getDisplayMetrics().density);
                            break;
                    }
                }
                break;
        }
    }

    @Override
    public View getView() {
        return this.view;
    }
}
