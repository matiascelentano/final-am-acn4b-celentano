package com.example.soundwaves;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    TextInputEditText loginEmail, loginPassword;
    ConstraintLayout progressBarContainer;
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
        progressBarContainer = findViewById(R.id.progressBarContainer);
        loginEmail = findViewById(R.id.loginEmailInput);
        loginPassword = findViewById(R.id.loginPasswordInput);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButtonLoginActivity);

        loginButton.setOnClickListener(this::login);
        registerButton.setOnClickListener(this::registerRedirect);

        Intent intent = getIntent();
        if(intent.hasExtra("email")){
            loginEmail.setText(intent.getStringExtra("email"));
        }
    }
    public void login(View view){
        String email, password;
        email = loginEmail.getText().toString();
        password = loginPassword.getText().toString();
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please a valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please your password", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(loginEmail.getText().toString(),loginPassword.getText().toString())
            .addOnCompleteListener(task -> {
                progressBarContainer.setVisibility(View.VISIBLE);
                if (task.isSuccessful()){
                    Log.i("authf",mAuth.getCurrentUser().getEmail());
                    Intent mainAct = new Intent(this, MainActivity.class);
                    startActivity(mainAct);
                    finish();
                }else {
                    progressBarContainer.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this,"Email or password is incorrect", Toast.LENGTH_SHORT).show();
                }
            });
    }
    public void registerRedirect(View view){
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }

}