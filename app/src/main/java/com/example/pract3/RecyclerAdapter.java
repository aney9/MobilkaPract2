package com.example.pract3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Products> productlist;

    public RecyclerAdapter(Context context, ArrayList<Products> productlist){
        this.context = context;
        this.productlist = productlist;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Products products = productlist.get(position);
        holder.Name.setText(products.getName());
        holder.Price.setText(products.getPrice());
        holder.Image.setImageResource(products.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, products.getDescription(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Na5.class);
                intent.putExtra("name", products.getName());
                intent.putExtra("price", products.getPrice());
                intent.putExtra("image", products.getImage());
                intent.putExtra("description", products.getDescription());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount(){
        return productlist.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView Name;
        TextView Price;
        ImageView Image;
        ViewHolder(View view){
            super(view);
            Name = view.findViewById(R.id.group_name);
            Price = view.findViewById(R.id.group_price);
            Image = view.findViewById(R.id.imageView);
        }
    }
}

