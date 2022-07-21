package com.example.flowershop.Fragment;

import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.flowershop.Flower;
import com.example.flowershop.HomeViewpagerAdapter;
import com.example.flowershop.R;
import com.example.flowershop.Recyclerview.RecyclerViewDiscountAdapter;
import com.example.flowershop.Recyclerview.RecyclerViewPopularAdapter;
import com.example.flowershop.Recyclerview.RecyclerViewRecentlyAdapter;
import com.example.flowershop.Recyclerview.RecyclerviewListCategoryAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {
    RecyclerViewPopularAdapter recyclerViewPopularAdapter;
    RecyclerViewDiscountAdapter recyclerViewDiscountAdapter;
    RecyclerViewRecentlyAdapter recyclerViewRecentlyAdapter;
    HomeViewpagerAdapter viewpagerAdapter;
    com.google.android.material.tabs.TabLayout dots;
    ImageView moreDiscount,morePopular;

    ArrayList<Flower> flowersPopular = new ArrayList<>();
    ArrayList<Flower> flowersDiscount = new ArrayList<>();
    ArrayList<Flower> flowersRecently = new ArrayList<>();
    ArrayList<Flower> flowersViewpager = new ArrayList<>();


    RecyclerView recyclerViewPopular;
    RecyclerView recyclerViewDiscount;
    RecyclerView recyclerViewRecently;

    ViewPager viewPagerHome;



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
        viewPagerHome = view.findViewById(R.id.homeViewPager);
        dots = view.findViewById(R.id.dots);
        moreDiscount = view.findViewById(R.id.moreDiscount);
        morePopular = view.findViewById(R.id.morePopular);

        flowersPopular.add(new Flower("bonsai", R.drawable.aloe_vera, 5));
        flowersPopular.add(new Flower("calibrachoa", R.drawable.calibrachoa, 4));
        flowersPopular.add(new Flower("agapanthus", R.drawable.agapanthus, 2));
        flowersPopular.add(new Flower("lithops", R.drawable.lithops, 2));
        flowersPopular.add(new Flower("opuntia_cactus", R.drawable.flowering_kale, 3));
        flowersPopular.add(new Flower("opuntia_cactus", R.drawable.dianthus, 3));
        flowersPopular.add(new Flower("opuntia_cactus", R.drawable.agapanthus, 5));
        flowersPopular.add(new Flower("opuntia_cactus", R.drawable.bougainvillea, 4));


        flowersDiscount.add(new Flower("bonsai", R.drawable.penny_orange_jumpup, 50));
        flowersDiscount.add(new Flower("agapanthus", R.drawable.california_snow, 120));
        flowersDiscount.add(new Flower("lithops", R.drawable.cymbidium, 410));
        flowersDiscount.add(new Flower("opuntia_cactus", R.drawable.mexican_golden_barrel_cactus, 505));
        flowersDiscount.add(new Flower("opuntia_cactus", R.drawable.calibrachoa, 48));
        flowersDiscount.add(new Flower("opuntia_cactus", R.drawable.iris_siberica, 320));
        flowersDiscount.add(new Flower("opuntia_cactus", R.drawable.penny_orange_jumpup, 312));


        flowersRecently.add(new Flower("bonsai", R.drawable.pelargonium, 50));
        flowersRecently.add(new Flower("calibrachoa", R.drawable.calibrachoa, 75));
        flowersRecently.add(new Flower("agapanthus", R.drawable.pincushion, 100));
        flowersRecently.add(new Flower("lithops", R.drawable.penny_orange_jumpup, 50));
        flowersRecently.add(new Flower("opuntia_cactus", R.drawable.red_cactus, 80));
        flowersRecently.add(new Flower("opuntia_cactus", R.drawable.white_wedding, 80));
        flowersRecently.add(new Flower("opuntia_cactus", R.drawable.rosa_burgundy, 80));
        flowersRecently.add(new Flower("opuntia_cactus", R.drawable.calibrachoa, 80));


        flowersViewpager.add(new Flower("yellow pansy", R.drawable.yellow_pansy, 50));
        flowersViewpager.add(new Flower("rosa burgundy", R.drawable.rosa_burgundy, 75));
        flowersViewpager.add(new Flower("pincushion", R.drawable.pincushion, 100));
        flowersViewpager.add(new Flower("red cactus", R.drawable.red_cactus, 80));
        flowersViewpager.add(new Flower("red cactus", R.drawable.red_cactus, 80));


        recyclerViewPopularAdapter = new RecyclerViewPopularAdapter(getContext(), flowersPopular);
        recyclerViewDiscountAdapter = new RecyclerViewDiscountAdapter(getContext(), flowersDiscount);
        recyclerViewRecentlyAdapter = new RecyclerViewRecentlyAdapter(getContext(), flowersRecently);
        viewpagerAdapter = new HomeViewpagerAdapter(flowersViewpager);

        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewPopular.setAdapter(recyclerViewPopularAdapter);

        recyclerViewRecently.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewRecently.setAdapter(recyclerViewRecentlyAdapter);

        recyclerViewDiscount.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewDiscount.setAdapter(recyclerViewDiscountAdapter);

        viewPagerHome.setAdapter(viewpagerAdapter);
        dots.setupWithViewPager(viewPagerHome, true);
        viewPagerHome.setCurrentItem(0);
        viewpagerAdapter.setTimer(viewPagerHome, 5, 4,0);

        viewPagerHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewpagerAdapter.stopTimer();
                viewpagerAdapter.setTimer(viewPagerHome, 5, 5,position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        moreDiscount.setOnClickListener(this);
        morePopular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.moreDiscount:
            break;
            case R.id.morePopular:
            break;
        }
    }
}