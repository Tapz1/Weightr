package com.tapz.weightr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private EditText editEmail, editPassword, firstName, lastName, email, password, repassword;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        db = new DBHelper(this);

        // button is clickable once password is written
        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // checking if nameText field is null or not to enable/disable button
                if(editable.toString().equals("")){
                    buttonLogin.setEnabled(false);
                }else{
                    buttonLogin.setEnabled(true);
                }

            }
        });

        /* button listener for login */
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();

                if(email.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter in both fields", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkUserPass = db.checkEmailPassword(email, password);
                    if(checkUserPass){
                        Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
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

    public void createUser(){
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        buttonCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);

    }
}