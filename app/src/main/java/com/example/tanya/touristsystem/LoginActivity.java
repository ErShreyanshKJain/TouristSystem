package com.example.tanya.touristsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button signupbtn, signin;
    AutoCompleteTextView emailtext;
    EditText passwordtext;
    String enteredemail, enteredpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        signin = (Button) findViewById(R.id.email_sign_in_button);


        signupbtn = (Button) findViewById(R.id.signupbutton);
        signupbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,registeractivity.class);
                startActivity(intent);
                finish();
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                emailtext = (AutoCompleteTextView) findViewById(R.id.email);
                enteredemail = emailtext.getText().toString();

                passwordtext = (EditText) findViewById(R.id.password);
                enteredpassword = passwordtext.getText().toString();


                if (TextUtils.isEmpty(enteredemail)) {
                    Toast.makeText(getApplicationContext(), "Please enter Email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(enteredpassword)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_SHORT).show();
                } else {

                    mAuth.signInWithEmailAndPassword(enteredemail, enteredpassword)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.

                                    if (!task.isSuccessful()) {

                                        if (enteredpassword.length() < 6) {
                                            Toast.makeText(getApplicationContext(), "Password is too short", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(LoginActivity.this, "Authentication failed,check email and password", Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        Toast.makeText(getApplicationContext(),"Logging In",Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.putExtra("email", enteredemail);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });


                }

            }
        });

    }
}
