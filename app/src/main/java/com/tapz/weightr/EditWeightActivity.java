package com.tapz.weightr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tapz.weightr.DBContract.DBHelper;
import com.tapz.weightr.ViewDataModel;

import java.util.ArrayList;


public class EditWeightActivity extends AppCompatActivity {

    private int id;
    private String date, weight, weight_goal;
    Button updateButton, deleteWeightButton;
    EditText weightEdit, weightGoalEdit, dateEdit;
    DBHelper db;
    ViewDataModel viewDataModel;
    ArrayList<String> entryList;

    public EditWeightActivity(int id, String date, String weight, String weight_goal){
        this.id = id;
        this.date = date;
        this.weight = weight;
        this.weight_goal = weight_goal;
    }

    public EditWeightActivity(){}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_weight);

        db = new DBHelper(this);
        String date = getDate();
        String weight = getWeight();
        String weight_goal = getWeight_goal();


        dateEdit = (EditText) findViewById((R.id.dateEdit));
        weightEdit = (EditText) findViewById(R.id.weightEdit);
        weightGoalEdit = (EditText) findViewById(R.id.weightGoalEdit);
        updateButton = (Button) findViewById(R.id.updateButton);

        dateEdit.setText(date);
        weightEdit.setText(weight);
        weightGoalEdit.setText(String.valueOf(db.getWeightGoal()));

        String newDate = dateEdit.getText().toString();
        String newWeight = weightEdit.getText().toString();
        String newWeightGoal = weightGoalEdit.getText().toString();

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean edit_entry = db.editEntry(id, newDate, newWeight, newWeightGoal);
                if(edit_entry){
                    Toast.makeText(EditWeightActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ViewDataActivity.class);
                    startActivity(intent);
                }
            }
        });




    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getWeight() {
        return weight;
    }

    public String getWeight_goal() {
        return weight_goal;
    }
}