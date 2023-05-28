package com.example.dilibook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dilibook.saving.DataClass;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DataClass> dataList;

    public Adapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler,parent, false);
        return new MyViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTittle.setText(dataList.get(position).getDataTitle());
        holder.recDesc.setText(dataList.get(position).getDataDesc());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Tittle", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Description", dataList.get(holder.getAdapterPosition()).getDataDesc());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();

    }
}
class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTittle, recDesc;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        recImage = itemView.findViewById(R.id.recyclerImg);
        recTittle = itemView.findViewById(R.id.recyclerTittle);
        recDesc = itemView.findViewById(R.id.recyclerDesc);
        recCard = itemView.findViewById(R.id.recyclerCard);

    }
}
