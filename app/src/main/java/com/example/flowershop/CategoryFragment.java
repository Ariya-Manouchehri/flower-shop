package com.example.flowershop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {
    RecyclerviewCategoryAdapter recyclerviewCategoryAdapter;
    ArrayList<Flower> flowers = new ArrayList<>();
    RecyclerView recyclerviewCategory;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerviewCategory = view.findViewById(R.id.recyclerviewCategory);

        flowers.add(new Flower("bonsai", R.drawable.flower1, 50));
        flowers.add(new Flower("calibrachoa", R.drawable.flower2, 75));
        flowers.add(new Flower("agapanthus", R.drawable.flower3, 100));
        flowers.add(new Flower("lithops", R.drawable.flower4, 50));


        recyclerviewCategoryAdapter = new RecyclerviewCategoryAdapter(getContext(),flowers);

        recyclerviewCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerviewCategory.setAdapter(recyclerviewCategoryAdapter);
    }
}