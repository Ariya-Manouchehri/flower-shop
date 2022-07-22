package com.example.flowershop.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Comment;
import com.example.flowershop.R;
import com.example.flowershop.Specification;

import java.util.ArrayList;

public class SpecificationViewAdapter extends RecyclerView.Adapter<SpecificationViewAdapter.Holder> {
    ArrayList<Specification> specifications;
    Context context;

    public SpecificationViewAdapter(ArrayList<Specification> specifications, Context context) {
        this.specifications = specifications;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_specification, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.fill(specifications.get(position));
    }

    @Override
    public int getItemCount() {
        return specifications.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView name_specification, details_specification;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name_specification = itemView.findViewById(R.id.name_specification);
            details_specification = itemView.findViewById(R.id.details_specification);
        }

        public void fill(Specification specifications) {
            name_specification.setText(specifications.getName());
            details_specification.setText(specifications.getDetails());
        }
    }
}
