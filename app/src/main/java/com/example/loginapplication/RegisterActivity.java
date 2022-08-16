package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button btnSignup;
    EditText etRollNo,etEmail,etFirstName,etLastName,etSPassword,etSRePassword;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etRollNo=findViewById(R.id.etRollNo);
        etEmail=findViewById(R.id.etEmail);
        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
        etSPassword=findViewById(R.id.etSPassword);
        etSRePassword=findViewById(R.id.etSRePassword);
        btnSignup=findViewById(R.id.btnSignUpDone);
        db=new DatabaseHelper(this);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rollNo=etRollNo.getText().toString();
                String email=etEmail.getText().toString();
                String firstName=etFirstName.getText().toString();
                String lastName=etLastName.getText().toString();
                String etPassword=etSPassword.getText().toString();
                String  etRePassword=etSRePassword.getText().toString();

                if(rollNo.equals("") || email.equals("")|| firstName.equals("")|| lastName.equals("") || etPassword.equals("")|| etRePassword.equals("")){
                    Toast.makeText(RegisterActivity.this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(etPassword.equals(etRePassword)){
                        Boolean checkuser=db.checkUserName(rollNo);
                        if(checkuser==false){
                            Boolean insert= db.insertData(rollNo,email,firstName,lastName,etPassword);
                            if(insert == true){
                                Toast.makeText(RegisterActivity.this, "Registered Successfully!...", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this, "Registration Unsuccessful.", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this, "User Already exist", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}