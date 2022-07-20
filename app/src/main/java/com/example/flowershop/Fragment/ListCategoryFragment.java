package com.example.flowershop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Activity.HomeActivity;
import com.example.flowershop.Flower;
import com.example.flowershop.R;
import com.example.flowershop.Recyclerview.CartRecyclerViewAdapter;
import com.example.flowershop.Recyclerview.RecyclerviewListCategoryAdapter;

import java.util.ArrayList;

public class ListCategoryFragment extends Fragment {
    public static int number;
    ImageView imgTitle;
    RecyclerView recyclerviewListCategory;
    RecyclerviewListCategoryAdapter recyclerviewListCategoryAdapter;
    ArrayList<Flower> flowers = new ArrayList<>();
    RelativeLayout CategoryListRelativelayoutList;
    TextView categoryTitle;
    RelativeLayout category;

    public ListCategoryFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().findViewById(R.id.bottomNavigation).setVisibility(View.GONE);
        getActivity().findViewById(R.id.toolbar).setVisibility(View.GONE);
        HomeActivity.checkBackPressed = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerviewListCategory = view.findViewById(R.id.recyclerviewListCategory);
        CategoryListRelativelayoutList = view.findViewById(R.id.CategoryListRelativelayoutList);
        imgTitle = view.findViewById(R.id.imgTitle);
        categoryTitle = view.findViewById(R.id.categoryTitle);
        category = view.findViewById(R.id.category);

        switch (number) {
            case 0:
                CategoryListRelativelayoutList.setBackgroundColor(getResources().getColor(R.color.category1));
                imgTitle.setImageResource(R.drawable.flower1);
                categoryTitle.setText("Shrubs");
                category.setBackgroundColor(getResources().getColor(R.color.category1Title));

                flowers.add(new Flower("bonsai", R.drawable.aloe_vera, 500));
                flowers.add(new Flower("calibrachoa", R.drawable.calibrachoa, 715));
                flowers.add(new Flower("agapanthus", R.drawable.agapanthus, 100));
                flowers.add(new Flower("lithops", R.drawable.lithops, 50));
                flowers.add(new Flower("opuntia_cactus", R.drawable.flowering_kale, 87));
                flowers.add(new Flower("opuntia_cactus", R.drawable.dianthus, 800));
                flowers.add(new Flower("opuntia_cactus", R.drawable.agapanthus, 810));
                flowers.add(new Flower("opuntia_cactus", R.drawable.bougainvillea, 425));
                break;
            case 1:
                CategoryListRelativelayoutList.setBackgroundColor(getResources().getColor(R.color.category2));
                imgTitle.setImageResource(R.drawable.flower2);
                categoryTitle.setText("Container Plants");
                category.setBackgroundColor(getResources().getColor(R.color.category2Title));

                flowers.add(new Flower("bonsai", R.drawable.bonsai, 500));
                flowers.add(new Flower("calibrachoa", R.drawable.mexican_fencepost_cactus, 715));
                flowers.add(new Flower("agapanthus", R.drawable.rosa_burgundy, 100));
                flowers.add(new Flower("lithops", R.drawable.cymbidium, 50));
                flowers.add(new Flower("opuntia_cactus", R.drawable.flowering_kale, 87));
                flowers.add(new Flower("opuntia_cactus", R.drawable.red_cactus, 800));
                flowers.add(new Flower("opuntia_cactus", R.drawable.dianthus, 810));
                flowers.add(new Flower("opuntia_cactus", R.drawable.salvia, 425));
                break;
            case 2:
                CategoryListRelativelayoutList.setBackgroundColor(getResources().getColor(R.color.category3));
                imgTitle.setImageResource(R.drawable.flower3);
                categoryTitle.setText("Herbaceous Perennials");
                category.setBackgroundColor(getResources().getColor(R.color.category3Title));

                flowers.add(new Flower("bonsai", R.drawable.red_cactus, 500));
                flowers.add(new Flower("calibrachoa", R.drawable.dusty_miller, 715));
                flowers.add(new Flower("agapanthus", R.drawable.agapanthus, 100));
                flowers.add(new Flower("lithops", R.drawable.lithops, 50));
                flowers.add(new Flower("opuntia_cactus", R.drawable.salvia, 87));
                flowers.add(new Flower("opuntia_cactus", R.drawable.haight_ashbury, 800));
                flowers.add(new Flower("opuntia_cactus", R.drawable.penny_orange_jumpup, 810));
                flowers.add(new Flower("opuntia_cactus", R.drawable.pincushion, 425));
                break;
            case 3:
                CategoryListRelativelayoutList.setBackgroundColor(getResources().getColor(R.color.category4));
                imgTitle.setImageResource(R.drawable.flower4);
                categoryTitle.setText("Cacti & Succulents");
                category.setBackgroundColor(getResources().getColor(R.color.category4Title));

                flowers.add(new Flower("bonsai", R.drawable.pansy_blue_shades, 500));
                flowers.add(new Flower("calibrachoa", R.drawable.rosa_burgundy, 715));
                flowers.add(new Flower("agapanthus", R.drawable.salvia, 100));
                flowers.add(new Flower("lithops", R.drawable.lithops, 50));
                flowers.add(new Flower("opuntia_cactus", R.drawable.flowering_kale, 87));
                flowers.add(new Flower("opuntia_cactus", R.drawable.mexican_golden_barrel_cactus, 800));
                flowers.add(new Flower("opuntia_cactus", R.drawable.agapanthus, 810));
                flowers.add(new Flower("opuntia_cactus", R.drawable.mona_lavender, 425));
                break;
        }

        recyclerviewListCategoryAdapter = new RecyclerviewListCategoryAdapter(getContext(),flowers);

        recyclerviewListCategory.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerviewListCategory.setAdapter(recyclerviewListCategoryAdapter);
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().findViewById(R.id.bottomNavigation).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
        HomeActivity.checkBackPressed = true;

    }
}