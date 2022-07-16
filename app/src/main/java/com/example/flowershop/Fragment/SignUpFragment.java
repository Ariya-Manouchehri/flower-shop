package com.example.flowershop.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.flowershop.Activity.HomeActivity;
import com.example.flowershop.R;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpFragment extends Fragment implements View.OnClickListener {
TextInputEditText username,password,confirmPassword;
Button signUp_btn;
    public SignUpFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        confirmPassword = view.findViewById(R.id.confirmPassword);
        signUp_btn = view.findViewById(R.id.signUp_btn);

        signUp_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.container)).commit();
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}