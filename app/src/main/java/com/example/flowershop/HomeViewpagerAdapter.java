package com.example.flowershop;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeViewpagerAdapter extends PagerAdapter {
    final Handler handler = new Handler();
    public Timer swipeTimer ;
    ArrayList<Flower> flowers;

    public HomeViewpagerAdapter(ArrayList<Flower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public int getCount() {
        return flowers.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (RelativeLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.slied_homeview, container, false);
        ImageView img = view.findViewById(R.id.image);
        TextView name = view.findViewById(R.id.name);

        img.setImageResource(flowers.get(position).getPhoto());
        name.setText(flowers.get(position).getName());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void setTimer(final ViewPager myPager, int time, final int numPages,int curPage){

        final Runnable Update = new Runnable() {
            int NUM_PAGES =numPages;
            int currentPage = curPage;
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                myPager.setCurrentItem(currentPage++, true);
            }
        };

        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, time*1000);
    }
    public void stopTimer(){
        swipeTimer.cancel();
    }
}
