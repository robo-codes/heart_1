package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class registerUser extends AppCompatActivity {

    private TextView banner, registerUser;
    private EditText editTextTextEmailAddress4, editTextTextEmailAddress3, editTextTextEmailAddress2, editTextTextPassword2;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    Switch LogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        registerUser = (Button) findViewById(R.id.button2);
        registerUser.setOnClickListener((View.OnClickListener) this);

        editTextTextEmailAddress4 = (EditText) findViewById(R.id.editTextTextEmailAddress4);
        editTextTextEmailAddress3 = (EditText) findViewById(R.id.editTextTextEmailAddress3);
        editTextTextEmailAddress2 = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        editTextTextPassword2 = (EditText) findViewById(R.id.editTextTextPassword2);

        progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        LogIn = (Switch) findViewById((R.id.switch3));
        LogIn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    startActivity(new Intent(registerUser.this, com.example.project2.MainActivity.class));
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String email = editTextTextEmailAddress2.getText().toString().trim();
        String password = editTextTextPassword2.getText().toString().trim();
        String fullName = editTextTextEmailAddress4.getText().toString().trim();
        String PatientOrDoctor = editTextTextEmailAddress3.getText().toString().trim();

        if(fullName.isEmpty()){
            editTextTextEmailAddress4.setError("Full name is required");
            editTextTextEmailAddress4.requestFocus();
            return;
        }
        if(PatientOrDoctor.isEmpty()) {
            editTextTextEmailAddress3.setError("Are you the doctor or the patient?");
            editTextTextEmailAddress3.requestFocus();
            return;
        }
        if(email.isEmpty()) {
            editTextTextEmailAddress2.setError("Please provide your email address !");
            editTextTextEmailAddress2.requestFocus();
            return;
        }
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextTextEmailAddress2.setError("Please enter a valid Email !");
            editTextTextEmailAddress2.requestFocus();
            return;
        }
        if(password.isEmpty()) {
            editTextTextPassword2.setError("Password is required");
            editTextTextPassword2.requestFocus();
            return;
        }
        if(password.length() < 6) {
            editTextTextPassword2.setError("Please enter more than 6 characters.");
            editTextTextPassword2.requestFocus();
            return;
        }
    }
}