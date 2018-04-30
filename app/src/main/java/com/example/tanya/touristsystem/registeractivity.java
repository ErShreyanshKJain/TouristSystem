package com.example.tanya.touristsystem;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registeractivity extends AppCompatActivity {
    EditText name ,emailid ,signuppassword,mobileno;
    FirebaseAuth mauth;
    FirebaseUser user;
    DatabaseReference mDatabase;
    public Input input;
    String email,fullname,password,mobile;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);
        input = new Input();
        register = (Button) findViewById(R.id.register);
        mauth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("users");


        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                name = (EditText) findViewById(R.id.fullname);
                emailid = (EditText) findViewById(R.id.Emailsu);
                signuppassword = (EditText) findViewById(R.id.passwordsu);
                mobileno = (EditText) findViewById(R.id.mobile);

                fullname = name.getText().toString();
                email = emailid.getText().toString();
                password = signuppassword.getText().toString();
                mobile = mobileno.getText().toString();

                if(TextUtils.isEmpty(fullname)||TextUtils.isEmpty(email)||TextUtils.isEmpty(password)||TextUtils.isEmpty(mobile)) {
                    Toast.makeText(getApplicationContext(), "Enter credentials", Toast.LENGTH_SHORT).show();
                    return;


                }else if(TextUtils.isEmpty(fullname)){
                    Toast.makeText(getApplicationContext(), "Enter name", Toast.LENGTH_SHORT).show();
                    return;

                }else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }else  if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                } else if(TextUtils.isEmpty(mobile)){
                    Toast.makeText(getApplicationContext(), "Enter mobile number", Toast.LENGTH_SHORT).show();
                    return;
                }else if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    mauth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(registeractivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // Toast.makeText(signupActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(registeractivity.this, "Authentication failed." + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        user = mauth.getCurrentUser();
                                        String userId = user.getUid();


                                        input.setName(fullname);
                                        input.setMobile(mobile);



                                        String name = input.getName();
                                        String mobileno =input.getMobile();


                                        mDatabase.child(userId).child("FullName").setValue(name);
                                        mDatabase.child(userId).child("MobileNumber").setValue(mobileno);

                                        Toast.makeText(getApplicationContext(), "Registering you..", Toast.LENGTH_SHORT).show();
                                        Intent in =new Intent(registeractivity.this, MainActivity.class);
                                        in.putExtra( "email",email);
                                        startActivity(in);
                                        finish();
                                    }
                                }
                            });
                }
            }

        });

    }
    }

