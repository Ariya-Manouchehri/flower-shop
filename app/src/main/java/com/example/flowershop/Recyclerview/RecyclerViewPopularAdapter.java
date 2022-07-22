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

public class RecyclerViewPopularAdapter extends RecyclerView.Adapter<RecyclerViewPopularAdapter.Holder> {
    Context context;
    ArrayList<Flower> flowers;
    RecyclerviewListCategoryAdapter.onClickListener listener;


    public RecyclerViewPopularAdapter(Context context, ArrayList<Flower> flowers) {
        this.context = context;
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_popular,parent,false);
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
        TextView name,ratNumber;
                RatingBar rating;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.listImage);
            name = itemView.findViewById(R.id.name);
            ratNumber = itemView.findViewById(R.id.ratNumber);
            rating = itemView.findViewById(R.id.rating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.setOnClick(flowers.get(getAdapterPosition()));
                    }
                }
            });
        }
        public void fill(Flower flower){
            img.setImageResource(flower.getPhoto());
            name.setText(flower.getName());
            rating.setRating((float) flower.getRatingbar());
            ratNumber.setText(String.valueOf(flower.getRatingbar()*2));
        }


    }
    public interface onClickListener {
        void setOnClick(Flower flower);
    }

    public void setOnItemClickListener(RecyclerviewListCategoryAdapter.onClickListener listener) {
        this.listener = listener;
    }
}
