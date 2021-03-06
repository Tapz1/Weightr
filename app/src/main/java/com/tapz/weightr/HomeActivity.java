package com.tapz.weightr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tapz.weightr.DBContract.DBHelper;


public class HomeActivity extends AppCompatActivity {
    private Button enterWeightButton, action_viewWeightData;
    private EditText weightEditText;
    private TextView greetingTextView;
    private FloatingActionButton fab;
    DBHelper db;
    UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        weightEditText = (EditText) findViewById(R.id.weightEditText);
        enterWeightButton = (Button) findViewById(R.id.enterWeightButton);
        action_viewWeightData = (Button) findViewById(R.id.action_viewWeightData);
        greetingTextView = (TextView) findViewById(R.id.greetingTextView);
        fab = findViewById(R.id.fab);
        LocalDate todaysDate = LocalDate.now();

        db = new DBContract.DBHelper(this);
        //String email = user.getEmail().toString();

/*
        // prompt to enter weight goal
        if(!db.hasWeightGoal()){
            Intent intent = new Intent(getApplicationContext(), WeightGoalActivity.class);
            startActivity(intent);
        }
*/

        enterWeightButton.setEnabled(false);


        // button is clickable once password is written
        weightEditText.addTextChangedListener(new TextWatcher() {
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
                    enterWeightButton.setEnabled(false);
                }else{
                    enterWeightButton.setEnabled(true);
                }

            }
        });

        enterWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // grabs the weight as an integer
                //int weight = Integer.parseInt(weightEditText.getText().toString());
                String weight = weightEditText.getText().toString();
                String goal = String.valueOf(db.getWeightGoal());
                //String email = user.getEmail();

                Boolean insert = db.insertWeightData(String.valueOf(todaysDate),weight, goal);
                if(insert){
                    Toast.makeText(HomeActivity.this, "Weight Entered Successfully!", Toast.LENGTH_SHORT).show();
                    // refresh page
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(HomeActivity.this, "Unable to enter weight", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WeightGoalActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    /*  this is for the menu */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_viewWeightData:
                // view weight data selected
                intent = new Intent(getApplicationContext(), ViewDataActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_notifications:
                // view weight data selected
                intent = new Intent(getApplicationContext(), NotificationActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_logout:
                // Logout selected
                intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}