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

import com.example.flowershop.Comment;
import com.example.flowershop.Flower;
import com.example.flowershop.R;

import java.util.ArrayList;

public class CommentsViewAdapter extends RecyclerView.Adapter<CommentsViewAdapter.Holder> {
    ArrayList<Comment> comments;
    Context context;

    public CommentsViewAdapter(ArrayList<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_comments, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.fill(comments.get(position));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        RatingBar rating;
        TextView name, comment;

        public Holder(@NonNull View itemView) {
            super(itemView);
            rating = itemView.findViewById(R.id.rating);
            name = itemView.findViewById(R.id.name);
            comment = itemView.findViewById(R.id.comment);

        }

        public void fill(Comment comments) {
            name.setText(comments.getName());
            comment.setText(comments.getComment());
            rating.setRating(comments.getRating());
        }
    }
}
