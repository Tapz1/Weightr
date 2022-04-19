package com.tapz.weightr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tapz.weightr.R;
import com.tapz.weightr.ViewDataModel;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<ViewDataModel> arrayList;

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


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.mycustomlistview, null);
        TextView tv_date = (TextView) view.findViewById(R.id.date);
        TextView tv_weight = (TextView) view.findViewById(R.id.weight);
        TextView tv_weightGoal = (TextView) view.findViewById(R.id.weightGoal);

        ViewDataModel viewDataModel = arrayList.get(i);

        tv_date.setText(viewDataModel.getDate());
        tv_weight.setText(viewDataModel.getWeight());
        tv_weightGoal.setText(String.valueOf(viewDataModel.getWeight_goal()));

        return view;
    }
}
