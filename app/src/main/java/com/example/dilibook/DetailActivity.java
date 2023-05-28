package com.example.dilibook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
        TextView detailDesc, detailTittle;
        ImageView detailImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailImage = findViewById(R.id.detailImg);
        detailTittle = findViewById(R.id.detailTittle);
        detailDesc = findViewById(R.id.detailDesc);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailTittle.setText(bundle.getString("Title"));
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);


        }
     }
}