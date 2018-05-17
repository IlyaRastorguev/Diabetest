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
import android.widget.TableRow;
import android.widget.TextView;

import com.example.rasto.diabetest.Adapters.TextWatcherAdapter;
import com.example.rasto.diabetest.Constants.Components;
import com.example.rasto.diabetest.Constants.Patterns;
import com.example.rasto.diabetest.Interactors.LoginInteractor;
import com.example.rasto.diabetest.Interfaces.FragmentCallBack;
import com.example.rasto.diabetest.Interfaces.SwipeCallback;
import com.example.rasto.diabetest.Interfaces.Views.ILoginView;
import com.example.rasto.diabetest.Model.ApplicationState;
import com.example.rasto.diabetest.Presenter.LoginPresenter;
import com.example.rasto.diabetest.R;

import static com.example.rasto.diabetest.Constants.EventDirection.*;
import static com.example.rasto.diabetest.Constants.Fragments.*;

/**
 * Created by rasto on 2/25/2018.
 */

public class LoginFragment extends Fragment implements ILoginView, FragmentCallBack, SwipeCallback {

    private EditText email;
    private EditText pass;

    private Button login;
    private Button activateLoginTab;

    private final ApplicationState APP_STATE = ApplicationState.getInstance();


    private LoginPresenter loginPresenter;

    private View view;

    private void componentsInit() {
        email = (EditText) view.findViewById(R.id.email);
        email.addTextChangedListener(new TextWatcherAdapter(this.loginPresenter, email, Patterns.EMAIL));
        pass = (EditText) view.findViewById(R.id.pass);
        pass.addTextChangedListener(new TextWatcherAdapter(this.loginPresenter, pass, Patterns.PASSWORD));
        login = (Button) view.findViewById(R.id.login);
        activateLoginTab = (Button) view.findViewById(R.id.login_tab);
        loginPresenter.setOnActivateFragmentListener(activateLoginTab);
        loginPresenter.setOnActivateFragmentListener(activateLoginTab);
        loginPresenter.setSwipeListener(activateLoginTab);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.loginPresenter = new LoginPresenter(this, new LoginInteractor());
        this.view = inflater.inflate(R.layout.login_fragment, container, false);
        this.loginPresenter.onStart();
        componentsInit();
        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.validateCredentials(email, pass);
                loginPresenter.tryToLogin();
            }
        });
        return this.view;
    }

    @Override
    public void setFieldError(EditText fieldError) {
        fieldError.setBackgroundResource(R.drawable.error_input);
    }

    @Override
    public void hideFieldError(EditText fieldError) {
        fieldError.setBackgroundResource(R.drawable.input_background);
    }

    @Override
    public void showSnackBar(String message) {
        final SnackBarComponent snackBarComponent = new SnackBarComponent(view.findViewById(R.id.login_block), message);
        snackBarComponent.showSnackBar();
    }

    @Override
    public void goNext() {

    }

    @Override
    public String getResources(int id) {
        return getContext().getResources().getString(id);
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
                view.findViewById(R.id.active_part).setVisibility(View.VISIBLE);
                view.setY(64*APP_STATE.getDisplayMetrics().density);
                break;
            case SING_UP:
                view.findViewById(R.id.active_part).setVisibility(View.GONE);
                view.setVisibility(View.GONE);
                break;
            case NULL:
                view.findViewById(R.id.active_part).setVisibility(View.GONE);
                view.setY(APP_STATE.getDisplayMetrics().heightPixels - 256 * APP_STATE.getDisplayMetrics().density);
                break;
        }
    }

    @Override
    public void swipeCallBackHandler() {
        switch (APP_STATE.getCurrentActiveFragment()) {
            case LOGIN:
                break;
            case SING_UP:
                break;
        }
    }

    @Override
    public View getView() {
        return this.view;
    }
}
