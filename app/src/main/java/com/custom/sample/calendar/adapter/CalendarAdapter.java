package com.custom.sample.calendar.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.custom.sample.calendar.R;
import com.custom.sample.calendar.application.AppManager;
import com.custom.sample.calendar.application.Constant;

import java.util.ArrayList;
import java.util.HashMap;

public class CalendarAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<HashMap<String, String>> dates;
    LayoutInflater inflater;

    String TAG = "AttendanceCalendar";

    public CalendarAdapter(Context c, ArrayList<HashMap<String, String>> dates) {

        mContext = c;
        this.dates = dates;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return dates.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return dates.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.calendar_adapter, parent, false);
            mViewHolder = new MyViewHolder();

            mViewHolder.calendarCell = (RelativeLayout) convertView.findViewById(R.id.calendar_cell);
            mViewHolder.datesTxt = (TextView) convertView.findViewById(R.id.date);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        HashMap<String, String> dateList = dates.get(position);

        String result = "";

        int textSize = 0 , backgroundResource = 0 , textColor = 0 , year = 0 , month = 0;

        if(dateList.containsKey(Constant.WEAK_NAME)){
            textSize = 14;
            backgroundResource = R.drawable.week_background;
            textColor = Color.WHITE;
            result = dateList.get(Constant.WEAK_NAME);

        } else if(dateList.containsKey(Constant.OLD_DAYS)){

            result = dateList.get(Constant.OLD_DAYS);
            textSize = 12;
            backgroundResource = R.drawable.grid_cell;
            textColor = Color.GRAY;

        } else if(dateList.containsKey(Constant.PRESENT_DAYS)){

            year = AppManager.getSelectedYear();
            month = AppManager.getSelectedMonth();
            result = dateList.get(Constant.PRESENT_DAYS);
            int day = Integer.parseInt(result);
            if(AppManager.checkIfHoliday(year, month, day)){
                textColor = Color.parseColor("#FFFFFF");
                backgroundResource = R.drawable.box_cell;
            }  else {
                textColor = Color.BLACK;
                backgroundResource = R.drawable.grid_cell;
            }
            textSize = 14;

        } else if(dateList.containsKey(Constant.FUTURE_DAYS)){

            textSize = 14;
            backgroundResource = R.drawable.grid_cell;
            textColor = Color.GRAY;
            mViewHolder.datesTxt.setBackgroundResource(0);
            result = dateList.get(Constant.FUTURE_DAYS);
        }


        mViewHolder.calendarCell.setBackgroundResource(backgroundResource);
        mViewHolder.datesTxt.setTextSize(textSize);
        mViewHolder.datesTxt.setTextColor(textColor);
        mViewHolder.datesTxt.setText("" + result);

        return convertView;
    }

    private class MyViewHolder {

        RelativeLayout calendarCell;
        TextView datesTxt;
    }
}