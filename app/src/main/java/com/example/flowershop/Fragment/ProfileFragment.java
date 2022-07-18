package com.example.flowershop.Fragment;

import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flowershop.Activity.HomeActivity;
import com.example.flowershop.R;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    CardView userAccountInformationCardView;

    public ProfileFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userAccountInformationCardView = view.findViewById(R.id.userAccountInformationCardView);

        userAccountInformationCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction().replace(R.id.container, new UserAccountInformationFragment(), getString(R.string.UserAccountInformationFragmentTag)).addToBackStack(getString(R.string.UserAccountInformationFragmentTag)).commit();
    }
}