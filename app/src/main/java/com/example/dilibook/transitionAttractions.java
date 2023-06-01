package com.example.dilibook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dilibook.saving.UploadActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class transitionAttractions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_attractions);

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
    public void goTuf(View v){
        Intent intent = new Intent(this, AttractionTuf.class);
        startActivity(intent);
    }
    public void goMimino(View v){
        Intent intent = new Intent(this, AttractionMimino.class);
        startActivity(intent);
    }
}