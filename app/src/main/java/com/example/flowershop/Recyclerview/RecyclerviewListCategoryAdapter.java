package com.example.flowershop.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Flower;
import com.example.flowershop.R;

import java.util.ArrayList;

public class RecyclerviewListCategoryAdapter extends RecyclerView.Adapter<RecyclerviewListCategoryAdapter.Holder> {
    Context context;
    ArrayList<Flower> flowers;
    onClickListener listener;

    public RecyclerviewListCategoryAdapter(Context context, ArrayList<Flower> flowers) {
        this.context = context;
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_category_item, parent, false);
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
        ImageView listImage;
        TextView name, cost;
        ImageButton favoriteImage,addImage;

        public Holder(@NonNull View itemView) {
            super(itemView);
            listImage = itemView.findViewById(R.id.listImage);
            name = itemView.findViewById(R.id.name);
            cost = itemView.findViewById(R.id.cost);
            favoriteImage = itemView.findViewById(R.id.favoriteImage);
            addImage = itemView.findViewById(R.id.addImage);

            favoriteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (favoriteImage.getTag().equals("selectHeart")){
                        favoriteImage.startAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.fadein_favorite));
                        favoriteImage.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                        favoriteImage.setTag("notSelectHeart");
                    }else if (favoriteImage.getTag().equals("notSelectHeart")){
                        favoriteImage.startAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.fadeout_fragment));
                        favoriteImage.setImageResource(R.drawable.ic_baseline_favorite_24);
                        favoriteImage.setTag("selectHeart");
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.setOnClick(getAdapterPosition());
                    }
                }
            });
        }

        public void fill(Flower flower) {
            listImage.setBackgroundResource(flower.getPhoto());
            name.setText(flower.getName());
            cost.setText("$" + flower.getRatingbar());
        }
    }

    public interface onClickListener {
        void setOnClick(int Position);
    }

    public void setOnItemClickListener(onClickListener listener) {
        this.listener = listener;
    }
}
