package com.custom.sample.calendar.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.custom.sample.calendar.R;

import java.util.ArrayList;

public class YearAdapter extends ArrayAdapter<String> {

    private ArrayList<String> yearData;
    public Resources res;

    LayoutInflater inflater;

    public YearAdapter(Activity activity, int textViewResourceId, ArrayList<String> yearData, Resources res) {

        super(activity, textViewResourceId, yearData);
        this.yearData = yearData;
        this.res = res;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }


    public View getCustomView(int position, View convertView, ViewGroup parent) {


        View row = inflater.inflate(R.layout.calendar_data, parent, false);

        TextView label  = (TextView)row.findViewById(R.id.year_txt);


        String yearTxt = yearData.get(position);

        label.setText(yearTxt);

        return row;
    }

}
