package com.tapz.weightr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private Button buttonCreateAccount;
    private EditText firstName, lastName, email, password, repassword;
    DBContract.DBHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        buttonCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        db = new DBContract.DBHelper(this);

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name = firstName.getText().toString();
                String last_name = lastName.getText().toString();
                String email_address = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(first_name.equals("") || last_name.equals("") || email_address.equals("") ||
                        pass.equals("") || repass.equals("")){
                    Toast.makeText(SignupActivity.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                } else{
                    if(pass.equals(repass)){
                        Boolean checkUser = db.checkEmail(email_address);
                        if(!checkUser){
                            Boolean insert = db.insertLoginData(email_address, pass);
                            if(insert){
                                Toast.makeText(SignupActivity.this, "Registered Successfully!",
                                        Toast.LENGTH_SHORT).show();
                                // moving to home screen
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignupActivity.this, "Registration failed :(", Toast.LENGTH_SHORT).show();
                            }
                        } else{
                            Toast.makeText(SignupActivity.this, "User already exists!", Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        Toast.makeText(SignupActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}