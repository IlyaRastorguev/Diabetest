package com.example.rasto.diabetest.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rasto.diabetest.Adapters.TextWatcherAdapter;
import com.example.rasto.diabetest.Constants.Components;
import com.example.rasto.diabetest.Constants.Containers;
import com.example.rasto.diabetest.Constants.Patterns;
import com.example.rasto.diabetest.Constants.Fragments;
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
    private Button activateLoginTab;


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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.loginPresenter = new LoginPresenter(this, new LoginInteractor());
        this.view = inflater.inflate(R.layout.login_fragment, container, false);
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
    public void setFragment(Fragments screen, Containers toContainer) {

    }

    @Override
    public void hideElement(Components elementType, int id) {
        switch (elementType) {
            case LINEAR_LAYOUT:
                final LinearLayout linearLayout = (LinearLayout) view.findViewById(id);
                linearLayout.setVisibility(View.GONE);
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
            case LINEAR_LAYOUT:
                final LinearLayout linearLayout = (LinearLayout) view.findViewById(id);
                linearLayout.setVisibility(View.VISIBLE);
                break;
            case TEXT_VIEW:
                final TextView textView = (TextView) view.findViewById(id);
                textView.setVisibility(View.VISIBLE);
                break;
        }
    }
}
