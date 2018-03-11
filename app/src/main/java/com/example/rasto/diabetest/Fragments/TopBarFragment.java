package com.example.rasto.diabetest.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rasto.diabetest.Interfaces.Views.ITopBarView;
import com.example.rasto.diabetest.Presenter.TopBarPresenter;
import com.example.rasto.diabetest.R;

/**
 * Created by rasto on 2/25/2018.
 */

public class TopBarFragment extends Fragment implements ITopBarView {

    private Button backButton;
    private Button forwardButton;
    private TextView stepLabel;

    private View view;

    private TopBarPresenter topBarPresenter;

    private void componentsInit(View view) {
        backButton = (Button) view.findViewById(R.id.back_button);
        forwardButton = (Button) view.findViewById(R.id.forward_button);
        stepLabel = (TextView) view.findViewById(R.id.current_step);
    }

    @Override
    public void stepBack() {

    }

    @Override
    public void stepForward() {

    }

    @Override
    public void setCurrentStep(int stepNameId) {
        stepLabel.setText(stepNameId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.topBarPresenter = new TopBarPresenter(this);
        final View view = inflater.inflate(R.layout.top_bar_fragment, container, false);
        componentsInit(view);
        topBarPresenter.setCurrentStep();
        this.view = view;
        return view;
    }
}
