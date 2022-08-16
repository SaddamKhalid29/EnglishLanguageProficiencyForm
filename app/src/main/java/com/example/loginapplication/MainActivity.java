package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSignUp,btnSignIn;
    EditText etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignUp=findViewById(R.id.btnSignUp);
        btnSignIn=findViewById(R.id.btnLogin);
        etUsername=findViewById(R.id.etUserName);
        etPassword=findViewById(R.id.etPassword);
        db=new DatabaseHelper(this);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=etUsername.getText().toString();
                String password=etPassword.getText().toString();
                if(user.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this, "Please the email and password.", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass=db.checkusernamepassword(user,password);
                    if(checkuserpass==true){
                        Toast.makeText(MainActivity.this, "Sign in successfull!..", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    DatabaseHelper db;
}