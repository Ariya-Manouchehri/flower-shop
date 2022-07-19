package com.example.flowershop.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Flower;
import com.example.flowershop.R;
import com.example.flowershop.Recyclerview.RecyclerviewCategoryAdapter;

import java.util.ArrayList;


public class CategoryFragment extends Fragment implements RecyclerviewCategoryAdapter.onClickListener {
    RecyclerviewCategoryAdapter recyclerviewCategoryAdapter;
    ArrayList<Flower> flowers = new ArrayList<>();
    RecyclerView recyclerviewCategory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerviewCategory = view.findViewById(R.id.recyclerviewCategory);

        flowers.add(new Flower("bonsai", R.drawable.flower1, 50));
        flowers.add(new Flower("calibrachoa", R.drawable.flower2, 75));
        flowers.add(new Flower("agapanthus", R.drawable.flower3, 100));
        flowers.add(new Flower("lithops", R.drawable.flower4, 50));


        recyclerviewCategoryAdapter = new RecyclerviewCategoryAdapter(getContext(), flowers);

        recyclerviewCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerviewCategory.setAdapter(recyclerviewCategoryAdapter);

        recyclerviewCategoryAdapter.setOnItemClickListener(this);
    }

    @Override
    public void setOnClick(int Position) {
        switch (Position) {
            case 0:
                ListCategoryFragment.number = 0;
                getFragmentManager().beginTransaction().replace(R.id.container, new ListCategoryFragment(), getString(R.string.ListCategoryFragmentTag)).addToBackStack(getString(R.string.ListCategoryFragmentTag)).commit();
                break;
            case 1:
                ListCategoryFragment.number = 1;
                getFragmentManager().beginTransaction().replace(R.id.container, new ListCategoryFragment(), getString(R.string.ListCategoryFragmentTag)).addToBackStack(getString(R.string.ListCategoryFragmentTag)).commit();

                break;
            case 2:
                ListCategoryFragment.number = 2;
                getFragmentManager().beginTransaction().replace(R.id.container, new ListCategoryFragment(), getString(R.string.ListCategoryFragmentTag)).addToBackStack(getString(R.string.ListCategoryFragmentTag)).commit();

                break;
            case 3:
                ListCategoryFragment.number = 3;
                getFragmentManager().beginTransaction().replace(R.id.container, new ListCategoryFragment(), getString(R.string.ListCategoryFragmentTag)).addToBackStack(getString(R.string.ListCategoryFragmentTag)).commit();
                break;
        }
    }
}