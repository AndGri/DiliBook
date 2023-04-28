package com.example.dilibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WalkShahumyan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_shahumyan);
    }
    public void goBack(View v){
        Intent intent = new Intent(this, transitionForWalk.class);
        startActivity(intent);
    }
}