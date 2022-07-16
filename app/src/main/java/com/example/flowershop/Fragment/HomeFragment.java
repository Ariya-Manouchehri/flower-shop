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
import com.example.flowershop.Recyclerview.RecyclerViewDiscountAdapter;
import com.example.flowershop.Recyclerview.RecyclerViewPopularAdapter;
import com.example.flowershop.Recyclerview.RecyclerViewRecentlyAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerViewPopularAdapter recyclerViewPopularAdapter;
    RecyclerViewDiscountAdapter recyclerViewDiscountAdapter;
    RecyclerViewRecentlyAdapter recyclerViewRecentlyAdapter;

    ArrayList<Flower> flowers = new ArrayList<>();
    ArrayList<Flower> flowersPopular = new ArrayList<>();
    ArrayList<Flower> flowersDiscount = new ArrayList<>();
    ArrayList<Flower> flowersRecently = new ArrayList<>();

    RecyclerView recyclerViewPopular;
    RecyclerView recyclerViewDiscount;
    RecyclerView recyclerViewRecently;


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
        recyclerViewPopular = view.findViewById(R.id.recyclerViewPopular);
        recyclerViewRecently = view.findViewById(R.id.recyclerViewRecently);
        recyclerViewDiscount = view.findViewById(R.id.recyclerViewDiscount);

        flowersPopular.add(new Flower("bonsai", R.drawable.aloe_vera, 50));
        flowersPopular.add(new Flower("calibrachoa", R.drawable.calibrachoa, 75));
        flowersPopular.add(new Flower("agapanthus", R.drawable.agapanthus, 100));
        flowersPopular.add(new Flower("lithops", R.drawable.lithops, 50));
        flowersPopular.add(new Flower("opuntia_cactus", R.drawable.flowering_kale, 80));
        flowersPopular.add(new Flower("opuntia_cactus", R.drawable.dianthus, 80));
        flowersPopular.add(new Flower("opuntia_cactus", R.drawable.agapanthus, 80));
        flowersPopular.add(new Flower("opuntia_cactus", R.drawable.bougainvillea, 80));


        flowersDiscount.add(new Flower("bonsai", R.drawable.penny_orange_jumpup, 50));
        flowersDiscount.add(new Flower("agapanthus", R.drawable.california_snow, 100));
        flowersDiscount.add(new Flower("lithops", R.drawable.cymbidium, 50));
        flowersDiscount.add(new Flower("opuntia_cactus", R.drawable.mexican_golden_barrel_cactus, 80));
        flowersDiscount.add(new Flower("opuntia_cactus", R.drawable.calibrachoa, 80));
        flowersDiscount.add(new Flower("opuntia_cactus", R.drawable.iris_siberica, 80));
        flowersDiscount.add(new Flower("opuntia_cactus", R.drawable.penny_orange_jumpup, 80));


        flowersRecently.add(new Flower("bonsai", R.drawable.pelargonium, 50));
        flowersRecently.add(new Flower("calibrachoa", R.drawable.calibrachoa, 75));
        flowersRecently.add(new Flower("agapanthus", R.drawable.pincushion, 100));
        flowersRecently.add(new Flower("lithops", R.drawable.penny_orange_jumpup, 50));
        flowersRecently.add(new Flower("opuntia_cactus", R.drawable.red_cactus, 80));
        flowersRecently.add(new Flower("opuntia_cactus", R.drawable.white_wedding, 80));
        flowersRecently.add(new Flower("opuntia_cactus", R.drawable.rosa_burgundy, 80));
        flowersRecently.add(new Flower("opuntia_cactus", R.drawable.calibrachoa, 80));


        recyclerViewPopularAdapter = new RecyclerViewPopularAdapter(getContext(), flowersPopular);
        recyclerViewDiscountAdapter = new RecyclerViewDiscountAdapter(getContext(), flowersDiscount);
        recyclerViewRecentlyAdapter = new RecyclerViewRecentlyAdapter(getContext(), flowersRecently);

        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewPopular.setAdapter(recyclerViewPopularAdapter);

        recyclerViewRecently.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewRecently.setAdapter(recyclerViewRecentlyAdapter);

        recyclerViewDiscount.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewDiscount.setAdapter(recyclerViewDiscountAdapter);
    }
}