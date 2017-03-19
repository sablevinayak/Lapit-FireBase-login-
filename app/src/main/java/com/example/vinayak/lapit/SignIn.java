package com.example.vinayak.lapit;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    Toolbar t_SignIn;
    Button btn_signIn;
    TextView txt_email, txt_passwd;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        t_SignIn = (Toolbar) findViewById(R.id.signIn);
        t_SignIn.setTitle("Sign In");
        setSupportActionBar(t_SignIn);

        mAuth = FirebaseAuth.getInstance();
        btn_signIn = (Button) findViewById(R.id.button2);
        txt_email = (TextView) findViewById(R.id.editText2);
        txt_passwd = (TextView) findViewById(R.id.editText);

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(SignIn.this, account.class));
                }
            }
        };
    }

    @Override


    protected  void onStart(){
            super.onStart();
            mAuth.addAuthStateListener(mAuthListener);
        }

    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    private void startSignIn(){
            String email = txt_email.getText().toString();
            String password = txt_passwd.getText().toString();

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                Toast.makeText(SignIn.this,"Empty field",Toast.LENGTH_SHORT).show();
            }
            else {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignIn.this, "Not SignIn succesfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(SignIn.this,"Signed In Succesfully",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
}