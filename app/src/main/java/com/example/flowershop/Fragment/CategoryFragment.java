package com.example.flowershop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.flowershop.R;


public class CategoryFragment extends Fragment implements View.OnClickListener {
    RelativeLayout category1, category2, category3, category4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        category1 = view.findViewById(R.id.category1);
        category2 = view.findViewById(R.id.category2);
        category3 = view.findViewById(R.id.category3);
        category4 = view.findViewById(R.id.category4);

        category1.setOnClickListener(this);
        category2.setOnClickListener(this);
        category3.setOnClickListener(this);
        category4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.category1:
                ListCategoryFragment.number = 0;
                getFragmentManager().beginTransaction().replace(R.id.container, new ListCategoryFragment(), getString(R.string.ListCategoryFragmentTag)).addToBackStack(getString(R.string.ListCategoryFragmentTag)).commit();
                break;
            case R.id.category2:
                ListCategoryFragment.number = 1;
                getFragmentManager().beginTransaction().replace(R.id.container, new ListCategoryFragment(), getString(R.string.ListCategoryFragmentTag)).addToBackStack(getString(R.string.ListCategoryFragmentTag)).commit();
                break;
            case R.id.category3:
                ListCategoryFragment.number = 2;
                getFragmentManager().beginTransaction().replace(R.id.container, new ListCategoryFragment(), getString(R.string.ListCategoryFragmentTag)).addToBackStack(getString(R.string.ListCategoryFragmentTag)).commit();
                break;
            case R.id.category4:
                ListCategoryFragment.number = 3;
                getFragmentManager().beginTransaction().replace(R.id.container, new ListCategoryFragment(), getString(R.string.ListCategoryFragmentTag)).addToBackStack(getString(R.string.ListCategoryFragmentTag)).commit();
                break;
        }
    }
}