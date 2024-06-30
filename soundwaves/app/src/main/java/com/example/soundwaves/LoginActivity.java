package com.example.soundwaves;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    TextInputEditText loginEmail, loginPassword;
    Button loginButton, registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginEmail = findViewById(R.id.loginEmailInput);
        loginPassword = findViewById(R.id.loginPasswordInput);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButtonLoginActivity);

        loginButton.setOnClickListener(this::login);
        registerButton.setOnClickListener(this::registerRedirect);
    }
    public void login(View view){
        mAuth.signInWithEmailAndPassword(loginEmail.getText().toString(),loginPassword.getText().toString())
            .addOnCompleteListener(this, task -> {
                if (task.isSuccessful()){
                    Log.i("authf",mAuth.getCurrentUser().getEmail());
                }
            });
    }
    public void registerRedirect(View view){
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }
}