package com.example.vinayak.lapit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class getStart extends AppCompatActivity {

    Toolbar t_SignIn;

    Button btn_signUp;
    TextView txt_email,txt_passwd,txt_con_passwd;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);
        t_SignIn = (Toolbar) findViewById(R.id.signIn);
        t_SignIn.setTitle("Sing Up");
        setSupportActionBar(t_SignIn);

        mAuth = FirebaseAuth.getInstance();
        btn_signUp = (Button) findViewById(R.id.btn_SingUp);
        txt_email = (TextView) findViewById(R.id.txt_UoEmail);
        txt_passwd = (TextView) findViewById(R.id.txt_UpPasswd);
        txt_con_passwd = (TextView) findViewById(R.id.txt_UpConPasswd);



        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Toast.makeText(getStart.this,"SignUp Succesfully",Toast.LENGTH_SHORT).show();
                }
            }
        };

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignUp();
            }
        });
    }

    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }



    private void startSignUp(){
        String upEmail = txt_email.getText().toString();
        String upPasswd = txt_passwd.getText().toString();
        String upConPasswd = txt_con_passwd.getText().toString();
            mAuth.createUserWithEmailAndPassword(upEmail,upPasswd).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()){
                            Toast.makeText(getStart.this,"Authentication failed",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getStart.this,"Authentication Done",Toast.LENGTH_SHORT).show();
                        }
                }
            });
        }

    }

