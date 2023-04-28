package com.example.dilibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AttractionTuf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_tuf);
    }
    public void goBack(View v){
        Intent intent = new Intent(this, transitionAttractions.class);
        startActivity(intent);

    }
}