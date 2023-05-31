package com.example.dilibook;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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
        Intent intent = new Intent(this, transitionAttractions.class);
        startActivity(intent);
    }
    public void goToWalk(View v){
        Intent intent = new Intent(this, transitionForWalk.class);
        startActivity(intent);
    }
    public void goToExpeditions(View v){
        Intent intent = new Intent(this, ExpeditionsActivity.class);
        startActivity(intent);
    }

}