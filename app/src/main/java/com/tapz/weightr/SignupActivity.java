package com.tapz.weightr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tapz.weightr.DBContract.DBHelper;

import java.util.Arrays;
import java.util.HashSet;

public class SignupActivity extends AppCompatActivity {

    private Button buttonCreateAccount;
    private EditText firstName, lastName, email, password, repassword;
    DBHelper db;
    public UserModel user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        buttonCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
        firstName = (EditText) findViewById(R.id.firstNameSignup);
        lastName = (EditText) findViewById(R.id.lastNameSignup);
        email = (EditText) findViewById(R.id.emailSignup);
        password = (EditText) findViewById(R.id.passwordSignup);
        repassword = (EditText) findViewById(R.id.repasswordSignup);
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
                    user = new UserModel(first_name, last_name, email_address);
                    if(passwordReqs(pass)){
                        // calls method for password requirements
                        if(pass.equals(repass)){
                            // if passwords match, checks if email isn't already in db
                            Boolean checkUser = db.checkEmail(email_address);
                            if(!checkUser){
                                Boolean insert = db.insertLoginData(first_name, last_name, email_address, pass);
                                if(insert){
                                    Toast.makeText(SignupActivity.this, "Registered Successfully!",
                                            Toast.LENGTH_SHORT).show();
                                    user = new UserModel(first_name, last_name, email_address);
                                    // moving to home screen
                                    Intent intent = new Intent(SignupActivity.this, WeightGoalActivity.class);
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
                    }else{
                        passwordReqs(pass);
                    }
                }
            }
        });
    }

    public Boolean passwordReqs(String password){
        if(password.length() < 8){
            Toast.makeText(this, "Password needs to be greater than 8 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

}