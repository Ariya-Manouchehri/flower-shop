package com.example.flowershop;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.Random;

public class HomeViewPagerAdapter extends PagerAdapter {
ArrayList<Integer> images;
int[]colors={Color.RED,Color.GREEN,Color.YELLOW,Color.BLUE};
    Random random = new Random();

    public HomeViewPagerAdapter(ArrayList<Integer> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.slied_homeview,container,false);
        ImageView imageView = view.findViewById(R.id.slideImage);
        imageView.setImageResource(images.get(position));

        imageView.setBackgroundColor(colors[random.nextInt(colors.length)]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
