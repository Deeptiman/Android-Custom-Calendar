package com.custom.sample.calendar.calendarmanager;


import com.custom.sample.calendar.application.Constant;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CalendarManager {

    public static int month_day [] =  {31,28,31,30,31,30,31,31,30,31,30,31};

    public static String[] week = {"Su","Mo","Tu","We","Th","Fr","Sa"};

    public static String[] month = {"JAN","FEB","MAR","APR",
            "MAY","JUN","JUL","AUG",
            "SEP","OCT","NOV","DEC"};

    private static ArrayList<HashMap<String, String>> datesData = new ArrayList<HashMap<String, String>>();

    public static ArrayList<HashMap<String, String>> prepareCalendar(int sYear, int sMonth){

        datesData.clear();

        int day = 1;

        int hour = 12;

        int min = 10;

        Calendar cal = Calendar.getInstance();

        cal.set(sYear, sMonth, day, hour, min);

        int magic_num = cal.get(Calendar.DAY_OF_WEEK)-1;


        for(int i=0;i<week.length;i++){

            HashMap<String, String> data = new HashMap<String, String>();

            data.put(Constant.WEAK_NAME,week[i]);

            datesData.add(data);
        }


        if(sYear%4==0){
            month_day[1]=29;
        }

        int  count = 0 , start = 0 , end = 0;


        String key = "";


        key = Constant.OLD_DAYS;

        if(sMonth-1!=-1) {

            start = month_day[sMonth-1]-magic_num;

            end = month_day[sMonth-1];

        } else {

            start = month_day[0]-magic_num;

            end = month_day[0];

        }

        count = setList(start, end, count , key);


        key = Constant.PRESENT_DAYS;

        start = 0;

        end = month_day[sMonth];

        count = setList(start, end, count , key);


        int diff = 7 - count;

        key = Constant.FUTURE_DAYS;

        start = 0;

        end = diff;

        setList(start, end, count, key);

        return datesData;

    }

    private static int setList(int start, int end, int count, String key) {


        for(int i1=start;i1<end;i1++) {

            count++;

            if(count%7==0){

                count = 0;
            }


            HashMap<String, String> data = new HashMap<String, String>();

            data.put(key, String.valueOf(i1 + 1));

            datesData.add(data);

        }

        return count;
    }

}
