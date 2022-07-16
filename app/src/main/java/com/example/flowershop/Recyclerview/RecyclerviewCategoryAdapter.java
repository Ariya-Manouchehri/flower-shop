package com.example.flowershop.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Flower;
import com.example.flowershop.R;

import java.util.ArrayList;

public class RecyclerviewCategoryAdapter extends RecyclerView.Adapter<RecyclerviewCategoryAdapter.Holder> {
    Context context;
    ArrayList<Flower> flowers;
    int [] bgCategory ={R.drawable.bg_flower1,R.drawable.bg_flower2,R.drawable.bg_flower3,R.drawable.bg_flower4};

    public RecyclerviewCategoryAdapter(Context context, ArrayList<Flower> flowers) {
        this.context = context;
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_category, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.fill(flowers.get(position),position);
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imageListCategory;
        TextView nameListCategory, countListCategory;
        RelativeLayout RelativelayoutList;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageListCategory = itemView.findViewById(R.id.imageListCategory);
            nameListCategory = itemView.findViewById(R.id.nameListCategory);
            countListCategory = itemView.findViewById(R.id.countListCategory);
            RelativelayoutList = itemView.findViewById(R.id.RelativelayoutList);
        }

        public void fill(Flower flower,int position) {
            RelativelayoutList.setBackgroundResource(bgCategory[position]);
            imageListCategory.setImageResource(flower.getPhoto());
            nameListCategory.setText(flower.getName());
            countListCategory.setText(String.valueOf(flower.getRatingbar()) + " flowers");
        }
    }
}
