package com.example.dilibook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class transitionAttractions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_attractions);
    }
    public void goBack(View v){
        Intent intent = new Intent(this, RootActivity.class);
        startActivity(intent);
    }
    public void goTuf(View v){
        Intent intent = new Intent(this, AttractionTuf.class);
        startActivity(intent);
    }
    public void goMimino(View v){
        Intent intent = new Intent(this, AttractionMimino.class);
        startActivity(intent);
    }
}