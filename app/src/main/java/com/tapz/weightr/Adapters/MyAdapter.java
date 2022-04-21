package com.tapz.weightr.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.tapz.weightr.EditWeightActivity;
import com.tapz.weightr.R;
import com.tapz.weightr.ViewDataActivity;
import com.tapz.weightr.ViewDataModel;
import com.tapz.weightr.DBContract.DBHelper;
import com.tapz.weightr.EditWeightActivity;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<ViewDataModel> arrayList;
    EditWeightActivity editWeightActivity;

    public MyAdapter(Context context, ArrayList<ViewDataModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        DBHelper db = new DBHelper(context);


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.mycustomlistview, null);
        TextView tv_date = (TextView) view.findViewById(R.id.date);
        TextView tv_weight = (TextView) view.findViewById(R.id.weight);
        TextView tv_weightGoal = (TextView) view.findViewById(R.id.weightGoal);
        Button deleteButton = (Button) view.findViewById(R.id.deleteButton1);

        ViewDataModel viewDataModel = arrayList.get(i);

        tv_date.setText(viewDataModel.getDate());
        tv_weight.setText(viewDataModel.getWeight());
        tv_weightGoal.setText(viewDataModel.getWeight_goal());


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteEntry(viewDataModel.getId());

                /*Snackbar snackbar = Snackbar.make(view.findViewById(R.id.deleteButton),
                        R.string.entry_deleted, Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.undo, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Add question back
                        String date = viewDataModel.getDate();
                        String weight = viewDataModel.getWeight();
                        String weight_goal = viewDataModel.getWeight_goal();
                        db.insertWeightData(date, weight, weight_goal);

                    }
                });
                snackbar.show();*/

                Intent intent = new Intent(context.getApplicationContext(), ViewDataActivity.class);
                context.startActivity(intent);
            }
        });




        return view;
    }
}
