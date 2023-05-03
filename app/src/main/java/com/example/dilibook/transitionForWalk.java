package com.example.dilibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class transitionForWalk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_for_walk);
    }
    public void goBack(View v){
        Intent intent = new Intent(this, RootActivity.class);
        startActivity(intent);
    }
    public void goShahumyan(View v){
        Intent intent = new Intent(this, WalkShahumyan.class);
        startActivity(intent);
    }
    public void goToRoot(View v){
        Intent intent = new Intent(this, RootActivity.class);
        startActivity(intent);
    }
}