package com.example.dilibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dilibook.saving.UploadActivity;

public class ExpeditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expeditions);
    }

    public void goToRoot(View v){
        Intent intent = new Intent(this, RootActivity.class);
        startActivity(intent);
    }

    public void goBack(View v){
        Intent intent = new Intent(this, RootActivity.class);
        startActivity(intent);
    }

    public void goContentAdd(View v){
        Intent intent = new Intent(this, UploadActivity.class);
        startActivity(intent);
    }
}