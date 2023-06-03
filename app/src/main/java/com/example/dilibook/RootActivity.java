package com.example.dilibook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dilibook.saving.UploadActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.action_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.action_home:
                    return true;
                case R.id.action_logout:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
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