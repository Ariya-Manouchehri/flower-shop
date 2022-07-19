package com.example.flowershop.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Flower;
import com.example.flowershop.R;
import com.example.flowershop.SplashActivity;

import java.util.ArrayList;

public class FavoriteRecyclerViewAdapter extends RecyclerView.Adapter<FavoriteRecyclerViewAdapter.Holder> {
    ArrayList<Flower> flowers;
    Context context;

    public FavoriteRecyclerViewAdapter(ArrayList<Flower> flowers, Context context) {
        this.flowers = flowers;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoriteRecyclerViewAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_favorite, parent, false);
        return new FavoriteRecyclerViewAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.fill(flowers.get(position));
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView flowerImage;
        TextView flowerName;
        ImageButton favoriteImage;

        public Holder(@NonNull View itemView) {
            super(itemView);
            flowerImage = itemView.findViewById(R.id.listImage);
            flowerName = itemView.findViewById(R.id.name);
            favoriteImage = itemView.findViewById(R.id.favoriteImage);

            favoriteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (favoriteImage.getTag().equals("selectHeart")){
                        favoriteImage.startAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.fadein_favorite));
                        favoriteImage.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                        favoriteImage.setTag("notSelectHeart");
                    }else if (favoriteImage.getTag().equals("notSelectHeart")){
                        favoriteImage.startAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.fadein_fragment));
                        favoriteImage.setImageResource(R.drawable.ic_baseline_favorite_24);
                        favoriteImage.setTag("selectHeart");
                    }
                }
            });
        }

        public void fill(Flower flower) {
            flowerImage.setImageResource(flower.getPhoto());
            flowerName.setText(flower.getName());
        }
    }
}
