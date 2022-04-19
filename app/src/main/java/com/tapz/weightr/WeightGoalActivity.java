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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tapz.weightr.DBContract.DBHelper;

public class WeightGoalActivity extends AppCompatActivity {

    private Button weightGoalButton;
    private EditText weightGoalText;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_goal);

        weightGoalText = (EditText) findViewById(R.id.weightGoalEditText);
        weightGoalButton = (Button) findViewById(R.id.weightGoalButton);
        db = new DBContract.DBHelper(this);

        weightGoalButton.setEnabled(false);

        // button is clickable once password is written
        weightGoalText.addTextChangedListener(new TextWatcher() {
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
                    weightGoalButton.setEnabled(false);
                }else{
                    weightGoalButton.setEnabled(true);
                }

            }
        });

        weightGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weightGoal = weightGoalText.getText().toString();
                // method below already converts the string to an int
                Boolean insertWeightGoal = db.insertWeightGoal(weightGoal);
                if(insertWeightGoal){
                    Toast.makeText(WeightGoalActivity.this, "Goal Updated!", Toast.LENGTH_SHORT).show();
                    // moving to home screen
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(WeightGoalActivity.this, "Unable to update goal :(", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}