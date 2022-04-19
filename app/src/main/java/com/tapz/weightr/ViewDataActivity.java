package com.tapz.weightr;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.tapz.weightr.Adapters.MyAdapter;
import com.tapz.weightr.databinding.ActivityViewDataBinding;
import com.tapz.weightr.DBContract.DBHelper;

import java.util.ArrayList;

public class ViewDataActivity extends AppCompatActivity {

    TextView dataTextView;
    ListView listView;
    Button deleteButton;
    DBHelper db;
    ArrayList<ViewDataModel> userDataList;
    ArrayList<String> entryIds;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        deleteButton = (Button) findViewById(R.id.deleteButton1);
        listView = (ListView) findViewById(R.id.listView);
        db = new DBHelper(this);
        userDataList = new ArrayList<>();
        entryIds = new ArrayList<>();
        loadDataInListView();

/*
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < userDataList.size(); i++){
                    if()
                }
            }
        });
*/


    }



    private void loadDataInListView() {
        userDataList = db.getWeightData();
        myAdapter = new MyAdapter(this, userDataList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

    }


}