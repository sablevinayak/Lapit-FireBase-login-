package com.example.vinayak.lapit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    Button btn_SignIn ;
    Button btn_GetStart ;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        btn_SignIn = (Button) findViewById(R.id.btn_signIn);
        btn_GetStart = (Button) findViewById(R.id.btn_getStart);

        btn_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sigIn = new Intent(MainActivity.this,SignIn.class);
                startActivity(sigIn);
            }
        });

        btn_GetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getStart = new Intent(MainActivity.this, com.example.vinayak.lapit.getStart.class);
                startActivity(getStart);
            }
        });

    }
}
