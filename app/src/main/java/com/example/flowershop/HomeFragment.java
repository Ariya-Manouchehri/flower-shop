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

public class HomeFragment extends Fragment {
    RecyclerViewTopFlowerAdapter recyclerViewTopFlowerAdapter;
    ArrayList<Flower> flowers = new ArrayList<>();
    RecyclerView recyclerTopFlower;

    public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerTopFlower = view.findViewById(R.id.recyclerViewRecently);

        flowers.add(new Flower("bonsai", R.drawable.aloe_vera, 50));
        flowers.add(new Flower("calibrachoa", R.drawable.calibrachoa, 75));
        flowers.add(new Flower("agapanthus", R.drawable.agapanthus, 100));
        flowers.add(new Flower("lithops", R.drawable.lithops, 50));
        flowers.add(new Flower("opuntia_cactus", R.drawable.opuntia_cactus, 80));

        recyclerViewTopFlowerAdapter = new RecyclerViewTopFlowerAdapter(getContext(), flowers);
        recyclerTopFlower.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerTopFlower.setAdapter(recyclerViewTopFlowerAdapter);

    }
}