package com.example.flowershop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Activity.HomeActivity;
import com.example.flowershop.Flower;
import com.example.flowershop.R;
import com.example.flowershop.Recyclerview.FavoriteRecyclerViewAdapter;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {

RecyclerView favoriteRecyclerView;
FavoriteRecyclerViewAdapter favoriteRecyclerViewAdapter;
ArrayList<Flower> flowersFavorite = new ArrayList<>();


    public FavoriteFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().findViewById(R.id.bottomNavigation).setVisibility(View.GONE);
        HomeActivity.checkBackPressed = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favoriteRecyclerView = view.findViewById(R.id.favoriteRecyclerView);

        flowersFavorite.add(new Flower("bonsai", R.drawable.aloe_vera, 5));
        flowersFavorite.add(new Flower("calibrachoa", R.drawable.calibrachoa, 4));
        flowersFavorite.add(new Flower("agapanthus", R.drawable.agapanthus, 2));
        flowersFavorite.add(new Flower("lithops", R.drawable.lithops, 2));
        flowersFavorite.add(new Flower("opuntia_cactus", R.drawable.flowering_kale, 3));
        flowersFavorite.add(new Flower("opuntia_cactus", R.drawable.dianthus, 3));
        flowersFavorite.add(new Flower("opuntia_cactus", R.drawable.agapanthus, 5));
        flowersFavorite.add(new Flower("opuntia_cactus", R.drawable.bougainvillea, 4));

        favoriteRecyclerViewAdapter = new FavoriteRecyclerViewAdapter(flowersFavorite,getContext());
        favoriteRecyclerView.setAdapter(favoriteRecyclerViewAdapter);
        favoriteRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().findViewById(R.id.bottomNavigation).setVisibility(View.VISIBLE);
        HomeActivity.checkBackPressed = true;

    }
}