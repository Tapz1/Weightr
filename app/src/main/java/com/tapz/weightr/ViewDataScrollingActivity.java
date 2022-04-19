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
import android.widget.TextView;

import com.tapz.weightr.databinding.ActivityViewDataScrollingBinding;
import com.tapz.weightr.DBContract.DBHelper;

import java.util.ArrayList;

public class ViewDataScrollingActivity extends AppCompatActivity {

    TextView dataTextView;
    private ActivityViewDataScrollingBinding binding;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityViewDataScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        Cursor cursor = db.fetch();
        cursor.moveToFirst();
        dataTextView = (TextView) findViewById(R.id.dataTextView);
        dataTextView.setText(cursor.getString(0));

    }


}