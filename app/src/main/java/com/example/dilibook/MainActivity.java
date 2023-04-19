package com.example.dilibook;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dilibook.saving.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {
    Button buttonSignIn,buttonRegister;
    FirebaseAuth auth;
    FirebaseDatabase bc;
    DatabaseReference users;
    RelativeLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonRegister = findViewById(R.id.buttonRegister);
        main = findViewById(R.id.windows);
        auth = FirebaseAuth.getInstance();
        bc = FirebaseDatabase.getInstance();
        users = bc.getReference("users");

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegisterWindow();
            }
        });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignInWindow();
            }
        });
    }

    private void showSignInWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Войти");
        LayoutInflater inflater = LayoutInflater.from(this);
        View signin_window = inflater.inflate(R.layout.signin_window, null);
        dialog.setView(signin_window);
        MaterialEditText email = signin_window.findViewById(R.id.userEmail);
        MaterialEditText password = signin_window.findViewById(R.id.userPassword);
        dialog.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(main,"Введите почту!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(password.getText().toString().length() < 6){
                    Snackbar.make(main,"Введите пароль, более 6 символов!", Snackbar.LENGTH_LONG).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(MainActivity.this, RootActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(main, "ошибка входа  " + e.getMessage(), Snackbar.LENGTH_SHORT);
                    }
                });
            }

        });
        dialog.show();
    }

    private void showRegisterWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Зарегистрироваться");
        LayoutInflater inflater = LayoutInflater.from(this);
        View window_register = inflater.inflate(R.layout.window_register, null);
        dialog.setView(window_register);
        MaterialEditText email = window_register.findViewById(R.id.userEmail);
        MaterialEditText name = window_register.findViewById(R.id.userName);
        MaterialEditText password = window_register.findViewById(R.id.userPassword);
        dialog.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });dialog.setPositiveButton("Зарегистрировать", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            if(TextUtils.isEmpty(email.getText().toString())){
                Snackbar.make(main,"Введите почту!", Snackbar.LENGTH_SHORT).show();
                return;
            }
                if(TextUtils.isEmpty(name.getText().toString())){
                    Snackbar.make(main,"Введите имя!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(password.getText().toString().length() < 6){
                    Snackbar.make(main,"Введите пароль, более 6 символов!", Snackbar.LENGTH_LONG).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        User user = new User();
                        user.setEmail(email.getText().toString());
                        user.setName(name.getText().toString());
                        user.setEmail(password.getText().toString());

                        users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {

                            @Override
                            public void onSuccess(Void unused) {
                            Snackbar.make(main,"Пользователь зарегестрирован!", Snackbar.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(main, "ошибка регистрации  " + e.getMessage(), Snackbar.LENGTH_SHORT);
                            }
                        });
                    }
                });
            }
        });
        dialog.show();
    }

}