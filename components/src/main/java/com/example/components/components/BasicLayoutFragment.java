package com.example.components.components;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class BasicLayoutFragment extends Fragment {

    private View view;

    private void findComponents(ViewGroup viewGroup) {
        viewGroup.getChildCount();
        for (int i = 0; i <= viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);
            initComponent(view);
        }
    }

    private void initComponent(View view) {

    }

    private void findView(LayoutInflater inflater, ViewGroup container) {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        findView(inflater, container);
        findComponents((ViewGroup) view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
