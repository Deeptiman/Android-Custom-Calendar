package com.custom.sample.calendar.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;

import com.custom.sample.calendar.R;
import com.custom.sample.calendar.adapter.CalendarAdapter;
import com.custom.sample.calendar.adapter.MonthAdapter;
import com.custom.sample.calendar.adapter.YearAdapter;
import com.custom.sample.calendar.application.AppManager;
import com.custom.sample.calendar.calendarmanager.CalendarManager;

import java.util.ArrayList;
import java.util.HashMap;

public class CalendarActivity extends AppCompatActivity {

    Spinner mYearSpinner, mMonthSpinner;
    GridView mCalendarView;

    int selectedYear = 0, selectedMonth = 0;

    ArrayList<String> yearDataList, monthDataList;
    ArrayList<HashMap<String, String>> mCalendarDatesList;

    String[] month = CalendarManager.month;

    YearAdapter yearAdapter;
    MonthAdapter monthAdapter;
    CalendarAdapter mCalendarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        getSupportActionBar().hide();

        mYearSpinner = (Spinner) findViewById(R.id.year_spinner);
        mMonthSpinner = (Spinner) findViewById(R.id.month_spinner);
        mCalendarView = (GridView) findViewById(R.id.calendar_history);

        yearDataList = new ArrayList<String>();
        monthDataList = new ArrayList<String>();
        mCalendarDatesList = new ArrayList<HashMap<String, String>>();

        selectedYear = AppManager.getCurrentYear();
        selectedMonth = AppManager.getCurrentMonth();

        int yearPos = 0;
        int c = 0;
        for (int i = 1900; i < 3000; i++) {
            yearDataList.add("" + i);

            if(i==selectedYear)
                yearPos = c;

            c++;
        }

        for (int i = 0; i < month.length; i++) {
            monthDataList.add(month[i]);
        }

        Resources res = getResources();

        yearAdapter = new YearAdapter(this, R.layout.calendar_data, yearDataList, res);
        mYearSpinner.setAdapter(yearAdapter);

        monthAdapter = new MonthAdapter(this, R.layout.calendar_data, monthDataList, res);
        mMonthSpinner.setAdapter(monthAdapter);

        mCalendarAdapter = new CalendarAdapter(this, mCalendarDatesList);
        mCalendarView.setAdapter(mCalendarAdapter);

        AppManager.setSelectedYear(selectedYear);
        AppManager.setSelectedMonth(selectedMonth + 1);
        prepareCalendar(selectedYear, selectedMonth);

        mYearSpinner.setSelection(yearPos);
        mMonthSpinner.setSelection(AppManager.getCurrentMonth());

        mYearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedYear = Integer.parseInt(yearDataList.get(position));
                AppManager.setSelectedYear(selectedYear);
                prepareCalendar(selectedYear, selectedMonth);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mMonthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedMonth = position;
                AppManager.setSelectedMonth(selectedMonth + 1);
                prepareCalendar(selectedYear, selectedMonth);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void prepareCalendar(int sYear, int sMonth) {
        mCalendarDatesList.clear();
        mCalendarDatesList.addAll(CalendarManager.prepareCalendar(sYear, sMonth));
        mCalendarAdapter.notifyDataSetChanged();
    }

}
