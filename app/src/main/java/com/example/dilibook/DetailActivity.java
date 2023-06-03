package com.example.dilibook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.dilibook.saving.UploadActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailActivity extends AppCompatActivity {
    TextView detailDesc, detailTitle;
    ImageView detailImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailImage = findViewById(R.id.detailImg);
        detailTitle = findViewById(R.id.detailTitle);
        detailDesc = findViewById(R.id.detailDesc);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailTitle.setText(bundle.getString("Title"));
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);


            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
            bottomNavigationView.setSelectedItemId(R.id.action_home);
            bottomNavigationView.setOnItemSelectedListener(item -> {
                switch(item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(getApplicationContext(), RootActivity.class));
                        finish();
                        return true;
                    case R.id.action_back:
                        startActivity(new Intent(getApplicationContext(), RootActivity.class));
                        finish();
                        return true;
                    case R.id.action_add:
                        startActivity(new Intent(getApplicationContext(), UploadActivity.class));
                        finish();
                        return true;
                }
                return false;
            });
        }
    }
}