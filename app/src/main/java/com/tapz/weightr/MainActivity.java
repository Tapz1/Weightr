package com.tapz.weightr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tapz.weightr.DBContract.DBHelper;

public class MainActivity extends AppCompatActivity {

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
                    Toast.makeText(MainActivity.this, "Please enter in both fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(email.contains("=")){
                        // looks for SQL Injection
                        Toast.makeText(MainActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                        throw new IllegalArgumentException("Invalid Email");
                    }
                    Boolean checkUserPass = db.checkEmailPassword(email, password);
                    if(checkUserPass){
                        new UserModel()
                        Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Login!", Toast.LENGTH_SHORT).show();
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