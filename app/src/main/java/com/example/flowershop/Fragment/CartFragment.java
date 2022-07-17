package com.example.flowershop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Flower;
import com.example.flowershop.R;
import com.example.flowershop.Recyclerview.CartRecyclerViewAdapter;

import java.util.ArrayList;

public class CartFragment extends Fragment {
RecyclerView cartRecyclerView;
CartRecyclerViewAdapter cartRecyclerViewAdapter;
ArrayList<Flower> flowers = new ArrayList<>();
    public CartFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cartRecyclerView = view.findViewById(R.id.cartRecyclerView);

        flowers.add(new Flower("bonsai", R.drawable.aloe_vera, 500));
        flowers.add(new Flower("calibrachoa", R.drawable.calibrachoa, 715));
        flowers.add(new Flower("agapanthus", R.drawable.agapanthus, 1000));
        flowers.add(new Flower("lithops", R.drawable.lithops, 50));
        flowers.add(new Flower("opuntia_cactus", R.drawable.flowering_kale, 87));
        flowers.add(new Flower("opuntia_cactus", R.drawable.dianthus, 800));
        flowers.add(new Flower("opuntia_cactus", R.drawable.agapanthus, 810));
        flowers.add(new Flower("opuntia_cactus", R.drawable.bougainvillea, 425));

        cartRecyclerViewAdapter = new CartRecyclerViewAdapter(flowers,getContext());

        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cartRecyclerView.setAdapter(cartRecyclerViewAdapter);
    }
}