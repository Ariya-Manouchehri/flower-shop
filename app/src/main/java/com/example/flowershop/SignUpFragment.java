package com.example.flowershop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SignUpFragment extends Fragment {

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
    }

//    @Override
//    public void onClick(View v) {
//        if (checkUsername(username.getText().toString().trim())){
//
//        }
//
//        if (checkpassword(username.getText().toString().trim()));
//
//    }
//
//
//    private boolean checkUsername(String username) {
//        usernameLayout.setErrorEnabled(true);
//        if (username.length() < 4) {
//            usernameLayout.setError("Minimum length of username is 4.");
//            return false;
//        }
//        for (int i = 0; i < username.length(); i++) {
//            if (username.charAt(i) == ' ' || username.charAt(i) == '@' || username.charAt(i) == '!' || username.charAt(i) == '$' || username.charAt(i) == '%' || username.charAt(i) == '^' || username.charAt(i) == '#' || username.charAt(i) == '&' || username.charAt(i) == '*' || username.charAt(i) == '(' || username.charAt(i) == ')' || username.charAt(i) == '-' || username.charAt(i) == '_' || username.charAt(i) == '+' || username.charAt(i) == '=') {
//                usernameLayout.setError("username can`t contain this characters !@#$%^&*()_-+= and also empty space");
//                return false;
//            }
//        }
////        if (DataBas.hasUsername(name)) {
////            sign_up_error_label_username.setVisible(true);
////            sign_up_error_label_username.setText("username already exist try an other one!");
////            return false;
////        }
//        return true;
//    }
//
//
//    private boolean checkpassword(String password) {
//        if (password.length() < 8) {
//            sign_up_error_label_password.setVisible(true);
//            sign_up_error_label_password.setText("minimum length od password is 8.");
//            return false;
//        }
//        if (password.contains(" ")) {
//            sign_up_error_label_password.setVisible(true);
//            sign_up_error_label_password.setText("password cant contain empty space!");
//            return false;
//        }
//        if (!password.equals(conPass)) {
//            sign_up_error_label_password.setVisible(true);
//            sign_up_error_label_password.setText("password is not pair with confirm password!");
//            return false;
//        }
//        return true;
//    }
}