package com.example.rasto.diabetest.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.rasto.diabetest.Adapters.TextWatcherAdapter;
import com.example.rasto.diabetest.Constants.Patterns;
import com.example.rasto.diabetest.Interactors.LoginInteractor;
import com.example.rasto.diabetest.Interfaces.Views.ILoginView;
import com.example.rasto.diabetest.Presenter.LoginPresenter;
import com.example.rasto.diabetest.R;

/**
 * Created by rasto on 2/25/2018.
 */

public class LoginFragment extends Fragment implements ILoginView {

    private EditText email;
    private EditText pass;

    private Button login;
    private Button registration;

    private LoginPresenter loginPresenter;

    private View view;

    private void componentsInit(View view) {
        email = (EditText) view.findViewById(R.id.email);
        email.addTextChangedListener(new TextWatcherAdapter(this.loginPresenter, email, Patterns.EMAIL));
        pass = (EditText) view.findViewById(R.id.pass);
        pass.addTextChangedListener(new TextWatcherAdapter(this.loginPresenter, pass, Patterns.PASSWORD));
        login = (Button) view.findViewById(R.id.login);
        registration = (Button) view.findViewById(R.id.registration);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.loginPresenter = new LoginPresenter(this, new LoginInteractor());
        final View view = inflater.inflate(R.layout.login_fragment, container, false);
        componentsInit(view);
        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.validateCredentials(email, pass);
                loginPresenter.tryToLogin();
            }
        });
        this.view = view;
        return view;
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
        final SnackBarComponent snackBarComponent = new SnackBarComponent(this.view, message);
        snackBarComponent.showSnackBar();
    }

    @Override
    public void goNext() {

    }

}
