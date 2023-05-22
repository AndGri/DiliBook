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
    private List<DataClass> datalist;

    public Adapter(Context context, List<DataClass> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler,parent, false);
        return new MyViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(datalist.get(position).getDataImage()).into(holder.recImage);
        holder.recTopic.setText(datalist.get(position).getDataImage());
        holder.recDesc.setText(datalist.get(position).getDataDesc());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Картинка", datalist.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Название", datalist.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Описание", datalist.get(holder.getAdapterPosition()).getDataDesc());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();

    }
}
class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recTopic, recDesc;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        recImage = itemView.findViewById(R.id.recyclerImg);
        recTopic = itemView.findViewById(R.id.recyclerTopic);
        recDesc = itemView.findViewById(R.id.recyclerDesc);
        recCard = itemView.findViewById(R.id.recyclerCard);

    }
}
