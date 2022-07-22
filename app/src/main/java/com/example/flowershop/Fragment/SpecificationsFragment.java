package com.example.flowershop.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flowershop.R;
import com.example.flowershop.Recyclerview.SpecificationViewAdapter;
import com.example.flowershop.Specification;

import java.util.ArrayList;

public class SpecificationsFragment extends Fragment {
    ArrayList<Specification> specifications = new ArrayList<>();
    SpecificationViewAdapter specificationViewAdapter;
    RecyclerView RecyclerviewSpecification;

    public SpecificationsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        specifications.add(new Specification("name","Azalea"));
        specifications.add(new Specification("category","Shrubs"));
        specifications.add(new Specification("price","15.99"));
        specifications.add(new Specification("instructions","Large double. Good grower, heavy bloomer. Early to mid-season, acid loving plants. Plant in moist well drained soil with pH of 4.0-5.5."));
        specifications.add(new Specification("productId","1"));
        specifications.add(new Specification("productnumber","21"));
        specifications.add(new Specification("productnumber","21"));
        specifications.add(new Specification("productnumber","21"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_specifications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerviewSpecification = view.findViewById(R.id.RecyclerviewSpecification);



        specificationViewAdapter = new SpecificationViewAdapter(specifications,getContext());
        RecyclerviewSpecification.setAdapter(specificationViewAdapter);

        RecyclerviewSpecification.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}