package com.example.flowershop.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Flower;
import com.example.flowershop.R;

import java.util.ArrayList;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.Holder> {
    ArrayList<Flower> flowers;
    Context context;

    public CartRecyclerViewAdapter(ArrayList<Flower> flowers, Context context) {
        this.flowers = flowers;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_cart, parent, false);
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
        ImageView flowerImage;
        TextView flowerName, flowerPay;

        public Holder(@NonNull View itemView) {
            super(itemView);
            flowerImage = itemView.findViewById(R.id.flowerImage);
            flowerName = itemView.findViewById(R.id.flowerName);
            flowerPay = itemView.findViewById(R.id.flowerPay);

        }

        public void fill(Flower flower) {
            flowerImage.setImageResource(flower.getPhoto());
            flowerName.setText(flower.getName());
            flowerPay.setText(String.valueOf(flower.getRatingbar()));
        }
    }
}
