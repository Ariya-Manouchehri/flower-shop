package com.example.flowershop.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Flower;
import com.example.flowershop.R;

import java.util.ArrayList;

public class RecyclerViewDiscountAdapter extends RecyclerView.Adapter<RecyclerViewDiscountAdapter.Holder> {
    Context context;
    ArrayList<Flower> flowers;

    public RecyclerViewDiscountAdapter(Context context, ArrayList<Flower> flowers) {
        this.context = context;
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listhomeview,parent,false);
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
        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.listImage);
        }
        public void fill(Flower flower){
            img.setImageResource(flower.getPhoto());
        }
    }
}
