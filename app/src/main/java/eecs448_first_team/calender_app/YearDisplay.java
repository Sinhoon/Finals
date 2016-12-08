package eecs448_first_team.calender_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YearDisplay extends AppCompatActivity {

    public int[] array;
    public final static String DATA = "";
    final int dayIndex = 0;
    final int monthIndex = 1;
    final int yearIndex = 2;
    final int firstDayOfMonth = 3;
    final int sundayDayForWeekView = 4;
    final int numOfDaysInMonth = 5;
    final int numOfDaysInPrevMonth = 6;
    final int weekNum = 7;


    int nullDate = SafeDate.day00.getDate();
    int fallYear = SafeDate.fallYear.getDate();
    int springYear = SafeDate.springYear.getDate();
    int day30 = SafeDate.day30.getDate();
    int day31 = SafeDate.day31.getDate();

    public int Year, Month, Day, Weekday;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        array = new int[8];
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_year_display);
        CalendarView calender;
        calender = (CalendarView) findViewById(R.id.calender);

        Intent getToYear = getIntent();
        int year = 2016;
        int[] dataInputArray = getToYear.getIntArrayExtra(DATA);
        if((dataInputArray != null) && (dataInputArray.length >= yearIndex)) //if year supplied by previous activity, use it, else use default 2016
            year = dataInputArray[yearIndex];
        else
            year = 2016;

        SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy hh:mm");
        try
        {
            Date date = sdf.parse("1-8-2016 00:00");
            calender.setMinDate(date.getTime()); //prevents date from going before Aug 1st
        }
        catch(ParseException e) {
            //googled off of the internet
            calender.setMinDate(1470027600000l);
        }
        try
        {
            Date date = sdf.parse("31-5-2017 00:00");
            calender.setMaxDate(date.getTime()); //prevents date from going before Aug 1st
        }
        catch(ParseException e)
        {
            //googled off of the internet
            calender.setMaxDate(1496206800000l);
        }

        // Listener to catch selected date and save it to be sent to anothe activity
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override


            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth){
//                Toast.makeText(getApplicationContext(), dayOfMonth+"/"+month + "/" +year, Toast.LENGTH_LONG).show();
                Intent goToMonth = new Intent(YearDisplay.this, MonthView.class);
                switch(month)
                {
                    case(0): //January
                    {
                        array[dayIndex] = nullDate;
                        array[monthIndex] = SafeDate.January.getDate();
                        array[yearIndex] = springYear;
                        array[firstDayOfMonth] = SafeDate.day01.getDate();
                        array[sundayDayForWeekView] = nullDate;
                        array[numOfDaysInMonth] = day31;
                        array[numOfDaysInPrevMonth] = day31;
                        array[weekNum] = nullDate;
                        goToMonth.putExtra(DATA, array);
                        startActivity(goToMonth);
                        break;
                    }
                    case(1): //Feb
                    {
                        array[dayIndex] = nullDate;
                        array[monthIndex] = SafeDate.February.getDate();
                        array[yearIndex] = springYear;
                        array[firstDayOfMonth] = SafeDate.day04.getDate();
                        array[sundayDayForWeekView] = nullDate;
                        array[numOfDaysInMonth] = SafeDate.day28.getDate();
                        array[numOfDaysInPrevMonth] = day31;
                        array[weekNum] = nullDate;
                        goToMonth.putExtra(DATA, array);
                        startActivity(goToMonth);
                        break;
                    }
                    case(2): //March
                    {
                        array[dayIndex] = nullDate;
                        array[monthIndex] = SafeDate.March.getDate();
                        array[yearIndex] = springYear;
                        array[firstDayOfMonth] = SafeDate.day04.getDate();
                        array[sundayDayForWeekView] = nullDate;
                        array[numOfDaysInMonth] = day31;
                        array[numOfDaysInPrevMonth] = SafeDate.day28.getDate();
                        array[weekNum] = nullDate;
                        goToMonth.putExtra(DATA, array);
                        startActivity(goToMonth);
                        break;
                    }
                    case(3): //April
                    {
                        array[dayIndex] = nullDate;
                        array[monthIndex] = SafeDate.April.getDate();
                        array[yearIndex] = springYear;
                        array[firstDayOfMonth] = SafeDate.day07.getDate();
                        array[sundayDayForWeekView] = nullDate;
                        array[numOfDaysInMonth] = day30;
                        array[numOfDaysInPrevMonth] = day31;
                        array[weekNum] = nullDate;
                        goToMonth.putExtra(DATA, array);
                        startActivity(goToMonth);
                        break;
                    }
                    case(4)://May
                    {
                        array[dayIndex] = nullDate;
                        array[monthIndex] = SafeDate.May.getDate();
                        array[yearIndex] = springYear;
                        array[firstDayOfMonth] = SafeDate.day02.getDate();
                        array[sundayDayForWeekView] = nullDate;
                        array[numOfDaysInMonth] = day31;
                        array[numOfDaysInPrevMonth] = day30;
                        array[weekNum] = nullDate;
                        goToMonth.putExtra(DATA, array);
                        startActivity(goToMonth);
                        break;
                    }
                    case(7): //August
                    {
                        array[dayIndex] = nullDate;
                        array[monthIndex] = SafeDate.August.getDate();
                        array[yearIndex] = fallYear;
                        array[firstDayOfMonth] = SafeDate.day02.getDate();
                        array[sundayDayForWeekView] = nullDate;
                        array[numOfDaysInMonth] = day30;
                        array[numOfDaysInPrevMonth] = nullDate;
                        array[weekNum] = nullDate;
                        goToMonth.putExtra(DATA, array);
                        startActivity(goToMonth);
                        break;
                    }
                    case(8): //Sept
                    {
                        array[dayIndex] = nullDate;
                        array[monthIndex] =  SafeDate.September.getDate();
                        array[yearIndex] = fallYear;
                        array[firstDayOfMonth] =  SafeDate.day05.getDate();
                        array[sundayDayForWeekView] = nullDate;
                        array[numOfDaysInMonth] = day30;
                        array[numOfDaysInPrevMonth] = day31;
                        array[weekNum] = nullDate;
                        goToMonth.putExtra(DATA, array);
                        startActivity(goToMonth);
                        break;
                    }
                    case(9): //Oct
                    {
                        array[dayIndex] = nullDate;
                        array[monthIndex] =  SafeDate.October.getDate();
                        array[yearIndex] = fallYear;
                        array[firstDayOfMonth] =  SafeDate.day07.getDate();
                        array[sundayDayForWeekView] = nullDate;
                        array[numOfDaysInMonth] = day31;
                        array[numOfDaysInPrevMonth] = day30;
                        array[weekNum] = nullDate;
                        goToMonth.putExtra(DATA, array);
                        startActivity(goToMonth);
                        break;
                    }
                    case(10): //Nov
                    {
                        array[dayIndex] = nullDate;
                        array[monthIndex] =  SafeDate.November.getDate();
                        array[yearIndex] = fallYear;
                        array[firstDayOfMonth] =  SafeDate.day03.getDate();
                        array[sundayDayForWeekView] = nullDate;
                        array[numOfDaysInMonth] = day30;
                        array[numOfDaysInPrevMonth] = day31;
                        array[weekNum] = nullDate;
                        goToMonth.putExtra(DATA, array);
                        startActivity(goToMonth);
                        break;
                    }
                    case(11): //Dec
                    {
                        array[dayIndex] = nullDate;
                        array[monthIndex] = SafeDate.December.getDate();
                        array[yearIndex] = fallYear;
                        array[firstDayOfMonth] = SafeDate.day05.getDate();
                        array[sundayDayForWeekView] = nullDate;
                        array[numOfDaysInMonth] = day31;
                        array[numOfDaysInPrevMonth] = day30;
                        array[weekNum] = nullDate;
                        goToMonth.putExtra(DATA, array);
                        startActivity(goToMonth);
                        break;
                    }
                }


            }

        });
    }
}
