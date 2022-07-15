package com.example.flowershop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewTopFlowerAdapter extends RecyclerView.Adapter<RecyclerViewTopFlowerAdapter.Holder> {
    Context context;
    ArrayList<Flower> flowers;

    public RecyclerViewTopFlowerAdapter(Context context, ArrayList<Flower> flowers) {
        this.context = context;
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.slied_homeview,parent,false);
        return new Holder(view);
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
        ImageView img;
        TextView name;
        RatingBar ratingBar;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            ratingBar = itemView.findViewById(R.id.ratingbar);
        }
        public void fill(Flower flower){
            img.setImageResource(flower.getPhoto());
            name.setText(flower.getName());
            ratingBar.setProgress(flower.getRatingbar());
        }
    }
}
