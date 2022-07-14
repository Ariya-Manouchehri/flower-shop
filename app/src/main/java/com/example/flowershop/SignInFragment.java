package com.example.flowershop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class SignInFragment extends Fragment implements View.OnClickListener {
    TextInputEditText username, password;
    Button signIn_btn;
    TextView signup_text;

    public SignInFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        signIn_btn = view.findViewById(R.id.signIn_btn);
        signup_text = view.findViewById(R.id.signup_text);

        signIn_btn.setOnClickListener(this);

        signup_text.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signIn_btn:
                if (checkUser()) {
                }
                break;
            case R.id.signup_text:
                getFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadeout_fragment,R.anim.slidein_fragment,R.anim.fadein_fragment,R.anim.slideout_fragment).replace(R.id.container, new SignUpFragment(), getString(R.string.SignUpFragmentTag)).addToBackStack(getString(R.string.SignUpFragmentTag)).commit();
                break;
        }

    }

    private boolean checkUser() {
        return false;
    }
}