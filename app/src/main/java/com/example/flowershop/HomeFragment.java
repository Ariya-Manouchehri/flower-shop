package com.example.flowershop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    HomeViewPagerAdapter homeViewPagerAdapter;
    ArrayList<Integer> images=new ArrayList<>();
    ViewPager viewPager;
    public HomeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.HomeViewPager);
        for (int i = 0; i < 4; i++) {
        images.add(R.drawable.flower_icon);
        }
        homeViewPagerAdapter = new HomeViewPagerAdapter(images);
        viewPager.setAdapter(homeViewPagerAdapter);
    }
}