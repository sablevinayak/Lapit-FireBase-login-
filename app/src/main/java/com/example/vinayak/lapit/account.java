package com.example.vinayak.lapit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class account extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    Toolbar t_SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        t_SignIn = (Toolbar) findViewById(R.id.signIn);
        t_SignIn.setTitle("Account");
        setSupportActionBar(t_SignIn);

        mAuth = FirebaseAuth.getInstance();

    }
    
}
