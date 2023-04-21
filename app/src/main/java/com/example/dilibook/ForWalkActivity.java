package com.example.dilibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForWalkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_walk);
    }
    public void goBack(View v){
        Intent intent = new Intent(this, RootActivity.class);
        startActivity(intent);
    }
}