package com.example.dilibook;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;


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
                case R.id.action_logout:
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Выход");
                    builder.setMessage("Вы точно хотите выйти?");
                    builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
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