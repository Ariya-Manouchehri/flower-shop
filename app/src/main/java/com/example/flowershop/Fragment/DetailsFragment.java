package com.example.flowershop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.flowershop.Activity.HomeActivity;
import com.example.flowershop.Flower;
import com.example.flowershop.R;
import com.example.flowershop.Recyclerview.CartRecyclerViewAdapter;
import com.example.flowershop.Recyclerview.FavoriteRecyclerViewAdapter;
import com.example.flowershop.Recyclerview.RecyclerViewRecentlyAdapter;
import com.example.flowershop.ViewPagerDetailsAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DetailsFragment extends Fragment {
    Bundle bundle = new Bundle();
    ImageView detailsImage;
    TextView flowerName, cost;
    ViewPager viewpagerDetails;
    ViewPagerDetailsAdapter viewPagerDetailsAdapter;
    TabLayout tabLayout;

    RecyclerView recyclerViewSimilarProducts;
    RecyclerViewRecentlyAdapter recyclerViewRecentlyAdapter;
    ArrayList<Flower> flowers = new ArrayList<>();

    public DetailsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        getActivity().findViewById(R.id.bottomNavigation).setVisibility(View.GONE);
        getActivity().findViewById(R.id.toolbar).setVisibility(View.GONE);
        HomeActivity.checkBackPressed = false;


        flowers.add(new Flower("bonsai", R.drawable.aloe_vera, 5));
        flowers.add(new Flower("calibrachoa", R.drawable.calibrachoa, 4));
        flowers.add(new Flower("agapanthus", R.drawable.agapanthus, 2));
        flowers.add(new Flower("lithops", R.drawable.lithops, 2));
        flowers.add(new Flower("opuntia_cactus", R.drawable.flowering_kale, 3));
        flowers.add(new Flower("opuntia_cactus", R.drawable.dianthus, 3));
        flowers.add(new Flower("opuntia_cactus", R.drawable.agapanthus, 5));
        flowers.add(new Flower("opuntia_cactus", R.drawable.bougainvillea, 4));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailsImage = view.findViewById(R.id.detailsImage);
        flowerName = view.findViewById(R.id.flowerName);
        cost = view.findViewById(R.id.cost);
        viewpagerDetails = view.findViewById(R.id.viewpagerDetails);
        tabLayout = view.findViewById(R.id.tabLayout);
        recyclerViewSimilarProducts = view.findViewById(R.id.recyclerViewSimilarProducts);

        viewPagerDetailsAdapter = new ViewPagerDetailsAdapter(getChildFragmentManager());
        viewPagerDetailsAdapter.addMethod(new SpecificationsFragment(), "Specifications");
        viewPagerDetailsAdapter.addMethod(new CommentsFragment(), "Comments");
        viewPagerDetailsAdapter.addMethod(new RegisterCommentFragment(), "Register a Comment");

        viewpagerDetails.setAdapter(viewPagerDetailsAdapter);
        tabLayout.setupWithViewPager(viewpagerDetails);

        detailsImage.setImageResource(bundle.getInt("flower_photo"));
        flowerName.setText(bundle.getString("flower_name"));
        cost.setText("$" + bundle.getInt("flower_price"));


        recyclerViewRecentlyAdapter = new RecyclerViewRecentlyAdapter(getContext(), flowers);
        recyclerViewSimilarProducts.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewSimilarProducts.setAdapter(recyclerViewRecentlyAdapter);
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().findViewById(R.id.bottomNavigation).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
        HomeActivity.checkBackPressed = true;

    }
}