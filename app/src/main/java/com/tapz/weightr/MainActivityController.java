package com.tapz.weightr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tapz.weightr.DBContract.DBHelper;

public class MainActivityController extends AppCompatActivity {

    private Button buttonSignUp, buttonLogin, buttonCreateAccount;
    private EditText editEmail, editPassword;
    DBHelper db;
    public UserModel user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        db = new DBHelper(this);


        /* button listener for login */
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                // String first_name, last_name;

                if(email.equals("") || password.equals("")){
                    Toast.makeText(MainActivityController.this, "Please enter in both fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(email.contains("=")){
                        // looks for SQL Injection
                        Toast.makeText(MainActivityController.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                        throw new IllegalArgumentException("Invalid Email");
                    }
                    Boolean checkUserPass = db.checkEmailPassword(email, password);
                    if(checkUserPass){
                        String first_name = db.getUserData("fname", email);
                        String last_name = db.getUserData("lname", email);
                        user = new UserModel(first_name, last_name, email);
                        Toast.makeText(MainActivityController.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivityController.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(MainActivityController.this, "Invalid Login!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        /* button listener for signup */
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });


    }

}