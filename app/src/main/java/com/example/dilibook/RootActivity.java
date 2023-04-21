package com.example.dilibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
    }
    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void goToAttractions(View v){
        Intent intent = new Intent(this, AttractionActivity.class);
        startActivity(intent);
    }
    public void goToWalk(View v){
        Intent intent = new Intent(this, ForWalkActivity.class);
        startActivity(intent);
    }
    public void goToExpeditions(View v){
        Intent intent = new Intent(this, ExpeditionsActivity.class);
        startActivity(intent);
    }
}