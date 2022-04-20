package com.tapz.weightr;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
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

    }



    private void loadDataInListView() {
        userDataList = db.getWeightData();
        myAdapter = new MyAdapter(this, userDataList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dataview_menu, menu);
        return true;
    }

    /*  this is for the menu */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_viewHome:
                // home selected
                intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_logout:
                // Logout selected
                intent = new Intent(ViewDataActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}