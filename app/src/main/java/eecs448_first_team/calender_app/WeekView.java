
package eecs448_first_team.calender_app;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class WeekView extends AppCompatActivity implements View.OnClickListener {
    public final static String DATA = "";
    public int[] array;


    public String getMonth(int m)
    {
        if(m == 8)
        {
            return("Aug. ");
        }
        else if(m == 9)
        {
            return("Sept. ");
        }
        else if(m == 10)
        {
            return("Oct. ");
        }
        else if(m == 11)
        {
            return("Nov. ");
        }
        else if(m == 12)
        {
            return("Dec. ");
        }
        else if(m == 1)
        {
            return("Jan. ");
        }
        else if(m == 2)
        {
            return("Feb. ");
        }
        else if(m == 3)
        {
            return("Mar. ");
        }
        else if(m == 4)
        {
            return("Apr. ");
        }
        else if(m == 5)
        {
            return("May ");
        }
        else
        {
            return("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);

        findViewById(R.id.sunday).setOnClickListener(this);
        findViewById(R.id.monday).setOnClickListener(this);
        findViewById(R.id.tuesday).setOnClickListener(this);
        findViewById(R.id.wednesday).setOnClickListener(this);
        findViewById(R.id.thursday).setOnClickListener(this);
        findViewById(R.id.friday).setOnClickListener(this);
        findViewById(R.id.saturday).setOnClickListener(this);
        findViewById(R.id.monthButton).setOnClickListener(this);
        findViewById(R.id.yearButton).setOnClickListener(this);

        Intent getToWeek = getIntent();
        array = getToWeek.getIntArrayExtra(MonthView.DATA);

        TextView textView = (TextView) findViewById(R.id.year);
        if(array[2] == SafeDate.fallYear.getDate()) {
            textView.setText("2016");
        }
        else
        {
            textView.setText("2017");
        }
        fillWeek();
    }
    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case(R.id.monthButton):
            {
                Intent goToMonth = new Intent(this, MonthView.class);
                goToMonth.putExtra(DATA, array);
                startActivity(goToMonth);
                break;
            }
            case(R.id.yearButton):
            {
                Intent goToYear = new Intent(this, YearDisplay.class);
                startActivity(goToYear);
                break;
            }
            default:
            {
                GetWeekDay(view.getId());

                break;
            }
        }
    }
    public void GetWeekDay(int viewId)
    {
        TextView t = (TextView) findViewById(R.id.sunday);
        switch(viewId)
        {

            //array: [day, month, year, day of 1st, Sunday's day for WeekView, # days in month, # days in previous month, week #]
            case(R.id.sunday):
            {
                if(array[1] != 8 || array[7] != 1) // if the first week of August is displayed, the user can't click where there is no date
                {
                    array[0] = array[4]; // otherwise, the date of Sunday will be the correct date
                    Intent goToDay = new Intent(this, DayView.class);
                    goToDay.putExtra(DATA, array);
                    startActivity(goToDay);
                }
                break;
            }
            case(R.id.monday):
            {
                if(array[7] == 1 && array[4] != 1) // if the first week is split between two months
                {
                    if(array[4] == array[6]) // if Sunday was the last day of ending month
                    {
                        array[0] = 1; // the day will be the 1st of the month
                    }
                    else
                    {
                        array[0] = array[4]+1; // otherwise the date is the next day of the ending month
                    }
                }
                else if((array[7] == 5 && array[4]+6 > array[5]) || array[7] == 6) // if the fifth week is split between two months or it's the sixth week
                {
                    if(array[4] == array[5]) // if Sunday was the last day of the month
                    {
                        array[0] = 1; // the day will be the 1st of the next month
                    }
                    else
                    {
                        array[0] = array[4]+1; // otherwise the date is the next day of the month
                    }
                }
                else // if it is one of the middle weeks
                {
                    array[0] = array[4] + 1; // the date will be the next day after Sunday
                }
                Intent goToDay = new Intent(this, DayView.class);
                goToDay.putExtra(DATA, array);
                startActivity(goToDay);
                break;
            }
            case(R.id.tuesday):
            {
                if(array[7] == 1 && array[4] != 1) // if it's Week 1 and the month did not start on Sunday
                {
                    if(array[4] == array[6]) // if Sunday was last day of previous month
                    {
                        array[0] = 2; // Tuesday will be the 2nd
                    }
                    else if(array[4]+1 == array[6]) // if Monday was last day of previous month
                    {
                        array[0] = 1; // Tuesday will be the 1st
                    }
                    else
                    {
                        array[0] = array[4]+2; // otherwise it's the next day of the ending month
                    }
                }
                else if((array[7] == 5 && array[4]+6 > array[5]) || array[7] == 6) // if Week 5 is split between months or if it's the sixth week
                {
                    if(array[4] == array[5]) // if Sunday was last day of month
                    {
                        array[0] = 2; // Tuesday will be the 2nd of the next month
                    }
                    else if(array[4]+1 == array[5]) //if Monday was last day of month
                    {
                        array[0] = 1; // Tuesday will be the 1st of the next month
                    }
                    else
                    {
                        array[0] = array[4]+2; // otherwise move date forward
                    }
                }
                else // if it's a middle week
                {
                    array[0] = array[4] + 2; // move date forward
                }
                Intent goToDay = new Intent(this, DayView.class);
                goToDay.putExtra(DATA, array);
                startActivity(goToDay);
                break;
            }
            case(R.id.wednesday):
            {
                if(array[7] == 1 && array[4] != 1) // if it's Week 1 and doesn't start on Sunday
                {
                    if(array[4] == array[6]) //Sunday was last day of previous month
                    {
                        array[0] = 3; // Wednesday is the 3rd
                    }
                    else if(array[4]+1 == array[6]) //Monday was last day of previous month
                    {
                        array[0] = 2; // Wednesday is the 2nd
                    }
                    else if(array[4]+2 == array[6]) //Tuesday was last day of previous month
                    {
                        array[0] = 1; // Wednesday is the 1st
                    }
                    else
                    {
                        array[0] = array[4]+3; // Previous month continues
                    }
                }
                else if((array[7] == 5 && array[4]+6 > array[5]) || array[7] == 6) //Fifth week split between months or sixth week
                {
                    if(array[4] == array[5]) //Sunday was last day of month
                    {
                        array[0] = 3; //Wednesday is 3rd
                    }
                    else if(array[4]+1 == array[5]) //Monday was last day of month
                    {
                        array[0] = 2; //Wednesday is 2nd
                    }
                    else if(array[4]+2 == array[5]) //Tuesday was last day of month
                    {
                        array[0] = 1; //Wednesday is 1st
                    }
                    else
                    {
                        array[0] = array[4]+3; //Month continues
                    }
                }
                else // Middle week
                {
                    array[0] = array[4] + 3; //Month continues
                }
                Intent goToDay = new Intent(this, DayView.class);
                goToDay.putExtra(DATA, array);
                startActivity(goToDay);
                break;
            }
            case(R.id.thursday):
            {
                if(array[1] != 5 || array[7] != 5) // if the last week of May is displayed, user can't click where there is no date
                {
                    if(array[7] == 1 && array[4] != 1) //Week 1 and didn't start on Sunday
                    {
                        if(array[4] == array[6]) //Sunday was last day of previous month
                        {
                            array[0] = 4; //Thursday is the 4th
                        }
                        else if(array[4]+1 == array[6]) //Monday was last day of previous month
                        {
                            array[0] = 3; //Thursday is the 3rd
                        }
                        else if(array[4]+2 == array[6]) //Tuesday was last day of previous month
                        {
                            array[0] = 2; //Thursday is the 2nd
                        }
                        else if(array[4]+3 == array[6]) //Wednesday was last day of previous month
                        {
                            array[0] = 1; //Thursday is the 1st
                        }
                        else
                        {
                            array[0] = array[4]+4; //Previous month continues
                        }
                    }
                    else if((array[7] == 5 && array[4]+6 > array[5]) || array[7] == 6) //Fifth week is split between months or sixth week
                    {
                        if(array[4] == array[5]) //Sunday was last day of month
                        {
                            array[0] = 4; //Thurs is the 4th
                        }
                        else if(array[4]+1 == array[5]) //Monday was last day of month
                        {
                            array[0] = 3; //Thurs is the 3rd
                        }
                        else if(array[4]+2 == array[5]) //Tuesday was last day of month
                        {
                            array[0] = 2; //Thurs is the 2nd
                        }
                        else if(array[4]+3 == array[5]) //Wednesday was last day of month
                        {
                            array[0] = 1; //Thurs is the 1st
                        }
                        else
                        {
                            array[0] = array[4]+4; //Month continues
                        }
                    }
                    else //Middle week
                    {
                        array[0] = array[4] + 4; //Month continues
                    }
                    Intent goToDay = new Intent(this, DayView.class);
                    goToDay.putExtra(DATA, array);
                    startActivity(goToDay);
                }
                break;
            }
            case(R.id.friday):
            {
                if(array[1] != 5 || array[7] != 5) // if the last week of May is displayed, user can't click where there is no date
                {
                    if(array[7] == 1 && array[4] != 1) //Week 1 and didn't start on Sunday
                    {
                        if(array[4] == array[6]) //Sunday was last day of previous month
                        {
                            array[0] = 5; //Fri is the 5th
                        }
                        else if(array[4]+1 == array[6]) //Monday was last day of previous month
                        {
                            array[0] = 4; //Fri is the 4th
                        }
                        else if(array[4]+2 == array[6]) //Tuesday was last day of previous month
                        {
                            array[0] = 3; //Fri is the 5th
                        }
                        else if(array[4]+3 == array[6]) //Wednesday was last day of previous month
                        {
                            array[0] = 2; //Fri is the 2nd
                        }
                        else if(array[4]+4 == array[6]) //Thursday was last day of previous month
                        {
                            array[0] = 1; //Fri is the 1st
                        }
                        else
                        {
                            array[0] = array[4]+5; //Previous month continues
                        }
                    }
                    else if((array[7] == 5 && array[4]+6 > array[5]) || array[7] == 6) //Fifth week is split between months or sixth week
                    {
                        if(array[4] == array[5]) //Sunday was last day of month
                        {
                            array[0] = 5; //Fri is the 5th
                        }
                        else if(array[4]+1 == array[5]) //Monday was last day of month
                        {
                            array[0] = 4; //Fri is the 4th
                        }
                        else if(array[4]+2 == array[5]) //Tuesday was last day of month
                        {
                            array[0] = 3; //Fri is the 3rd
                        }
                        else if(array[4]+3 == array[5]) //Tuesday was last day of month
                        {
                            array[0] = 2; //Fri is the 2nd
                        }
                        else if(array[4]+4 == array[5]) //Thursday was last day of month
                        {
                            array[0] = 1; //Fri is the 1st
                        }
                        else
                        {
                            array[0] = array[4]+5; //Month continues
                        }
                    }
                    else //Middle week
                    {
                        array[0] = array[4] + 5; //Month continues
                    }
                    Intent goToDay = new Intent(this, DayView.class);
                    goToDay.putExtra(DATA, array);
                    startActivity(goToDay);
                }
                break;
            }
            case(R.id.saturday):
            {
                if(array[1] != 5 || array[7] != 5) // if the last week of May is displayed, user can't click where there is no date
                {
                    if(array[7] == 1 && array[4] != 1) //Week 1 and didn't start on Sunday
                    {
                        if(array[4] == array[6]) //Sunday was last day of previous month
                        {
                            array[0] = 6; //Sat is the 6th
                        }
                        else if(array[4]+1 == array[6]) //Monday was last day of previous month
                        {
                            array[0] = 5; //Sat is the 5th
                        }
                        else if(array[4]+2 == array[6]) //Tuesday was last day of previous month
                        {
                            array[0] = 4; //Sat is the 4th
                        }
                        else if(array[4]+3 == array[6]) //Wednesday was last day of previous month
                        {
                            array[0] = 3; //Sat is the 3rd
                        }
                        else if(array[4]+4 == array[6]) //Thursday was last day of previous month
                        {
                            array[0] = 2; //Sat is the 2nd
                        }
                        else if(array[4]+5 == array[6]) //Friday was last day of previous month
                        {
                            array[0] = 1; //Sat is the 1st
                        }
                        else
                        {
                            array[0] = array[4]+6; //Previous month continues
                        }
                    }
                    else if((array[7] == 5 && array[4]+6 > array[5]) || array[7] == 6) //Fifth week is split between months or sixth week
                    {
                        if(array[4] == array[5]) //Sunday was last day of month
                        {
                            array[0] = 6; //Sat is the 6th
                        }
                        else if(array[4]+1 == array[5]) //Monday was last day of month
                        {
                            array[0] = 5; //Sat is the 5th
                        }
                        else if(array[4]+2 == array[5]) //Tuesday was last day of month
                        {
                            array[0] = 4; //Sat is the 4th
                        }
                        else if(array[4]+3 == array[5]) //Wednesday was last day of month
                        {
                            array[0] = 3; //Sat is the 3rd
                        }
                        else if(array[4]+4 == array[5]) //Thursday was last day of month
                        {
                            array[0] = 2; //Sat is the 2nd
                        }
                        else if(array[4]+5 == array[5]) //Friday was last day of month
                        {
                            array[0] = 1; //Sat is the 1st
                        }
                        else
                        {
                            array[0] = array[4]+6; //Month continues
                        }
                    }
                    else //Middle week
                    {
                        array[0] = array[4] + 6; //Month continues
                    }
                    Intent goToDay = new Intent(this, DayView.class);
                    goToDay.putExtra(DATA, array);
                    startActivity(goToDay);
                }
                break;
            }
        }
    }

    public void fillWeek()
    {
        TextView t = (TextView) findViewById(R.id.sunday);
        if(array[1] == 8 && array[7] == 1) // The first week of August does not need Sunday filled in
        {
            t = (TextView) findViewById(R.id.monday);
            t.setText("Monday, " + getMonth(array[1]) + "1");
            t = (TextView) findViewById(R.id.tuesday);
            t.setText("Tuesday, " + getMonth(array[1]) + "2");
            t = (TextView) findViewById(R.id.wednesday);
            t.setText("Wednesday, " + getMonth(array[1]) + "3");
            t = (TextView) findViewById(R.id.thursday);
            t.setText("Thursday, " + getMonth(array[1]) + "4");
            t = (TextView) findViewById(R.id.friday);
            t.setText("Friday, " + getMonth(array[1]) + "5");
            t = (TextView) findViewById(R.id.saturday);
            t.setText("Saturday, " + getMonth(array[1]) + "6");
        }
        else if(array[1] == 5 && array[7] == 5) // The last week of May does not need Thursday,Friday,or Saturday
        {
            t.setText("Sunday, " + getMonth(array[1]) + array[4]);
            t = (TextView) findViewById(R.id.monday);
            t.setText("Monday, " + getMonth(array[1]) + (array[4]+1));
            t = (TextView) findViewById(R.id.tuesday);
            t.setText("Tuesday, " + getMonth(array[1]) + (array[4]+2));
            t = (TextView) findViewById(R.id.wednesday);
            t.setText("Wednesday, " + getMonth(array[1]) + (array[4]+3));
        }
        else if(array[7] == 1 && array[4] > 1) //First week and starts with another month
        {
            t.setText("Sunday, " + getMonth(array[1]-1) + array[4]);
            t = (TextView) findViewById(R.id.monday);
            if(array[4]+1 > array[6]) // if Sunday was the last day of the month, start Monday at the 1st
            {
                t.setText("Monday, " + getMonth(array[1]) + "1");
                t = (TextView) findViewById(R.id.tuesday);
                t.setText("Tuesday, " + getMonth(array[1]) + "2");
                t = (TextView) findViewById(R.id.wednesday);
                t.setText("Wednesday, " + getMonth(array[1]) + "3");
                t = (TextView) findViewById(R.id.thursday);
                t.setText("Thursday, " + getMonth(array[1]) + "4");
                t = (TextView) findViewById(R.id.friday);
                t.setText("Friday, " + getMonth(array[1]) + "5");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]) + "6");
                return;
            }
            else // continue the month into Monday
            {
                t.setText("Monday, " + getMonth(array[1]-1) + (array[4]+1));
            }
            t = (TextView) findViewById(R.id.tuesday);
            if(array[4]+2 > array[6]) // if Monday was the last day of the month, start Tuesday at the 1st
            {
                t.setText("Tuesday, " + getMonth(array[1]) + "1");
                t = (TextView) findViewById(R.id.wednesday);
                t.setText("Wednesday, " + getMonth(array[1]) + "2");
                t = (TextView) findViewById(R.id.thursday);
                t.setText("Thursday, " + getMonth(array[1]) + "3");
                t = (TextView) findViewById(R.id.friday);
                t.setText("Friday, " + getMonth(array[1]) + "4");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]) + "5");
                return;
            }
            else // continue the month into Tuesday
            {
                t.setText("Tuesday, " + getMonth(array[1]-1) + (array[4]+2));
            }
            t = (TextView) findViewById(R.id.wednesday);
            if(array[4]+3 > array[6]) // if Tuesday was the last day, start Wednesday at the 1st
            {
                t.setText("Wednesday, " + getMonth(array[1]) + "1");
                t = (TextView) findViewById(R.id.thursday);
                t.setText("Thursday, " + getMonth(array[1]) + "2");
                t = (TextView) findViewById(R.id.friday);
                t.setText("Friday, " + getMonth(array[1]) + "3");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]) + "4");
                return;
            }
            else // continue the month into Wednesday
            {
                t.setText("Wednesday, " + getMonth(array[1]-1) + (array[4]+3));
            }
            t = (TextView) findViewById(R.id.thursday);
            if(array[4]+4 > array[6]) // if Wednesday was the last day, start Thursday as the 1st
            {
                t.setText("Thursday, " + getMonth(array[1]) + "1");
                t = (TextView) findViewById(R.id.friday);
                t.setText("Friday, " + getMonth(array[1]) + "2");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]) + "3");
                return;
            }
            else // continue month into Thursday
            {
                t.setText("Thursday, " + getMonth(array[1]-1) + (array[4]+4));
            }
            t = (TextView) findViewById(R.id.friday);
            if(array[4]+5 > array[6]) // if Thursday was the last day, start Friday as the 1st
            {
                t.setText("Friday, " + getMonth(array[1]) + "1");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]) + "2");
                return;
            }
            else // continue month into Friday
            {
                t.setText("Friday, " + getMonth(array[1]-1) + (array[4]+5));
            }
            t = (TextView) findViewById(R.id.saturday);
            t.setText("Saturday, " + getMonth(array[1]) + "1");
        }
        else if(array[7] == 5 && array[4]+6 > array[5]) //Week 5 goes into next month
        {
            t.setText("Sunday, " + getMonth(array[1]) + array[4]);
            t = (TextView) findViewById(R.id.monday);
            if(array[4]+1 > array[5])
            {
                t.setText("Monday, " + getMonth(array[1]+1) + "1");
                t = (TextView) findViewById(R.id.tuesday);
                t.setText("Tuesday, " + getMonth(array[1]+1) + "2");
                t = (TextView) findViewById(R.id.wednesday);
                t.setText("Wednesday, " + getMonth(array[1]+1) + "3");
                t = (TextView) findViewById(R.id.thursday);
                t.setText("Thursday, " + getMonth(array[1]+1) + "4");
                t = (TextView) findViewById(R.id.friday);
                t.setText("Friday, " + getMonth(array[1]+1) + "5");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]+1) + "6");
                return;
            }
            else //Monday continues the current month
            {
                t.setText("Monday, " + getMonth(array[1]) + (array[4]+1));
            }
            t = (TextView) findViewById(R.id.tuesday);
            if(array[4]+2 > array[5]) // if the month ends on Monday, Tuesday is the 1st of next month
            {
                t.setText("Tuesday, " + getMonth(array[1]+1) + "1");
                t = (TextView) findViewById(R.id.wednesday);
                t.setText("Wednesday, " + getMonth(array[1]+1) + "2");
                t = (TextView) findViewById(R.id.thursday);
                t.setText("Thursday, " + getMonth(array[1]+1) + "3");
                t = (TextView) findViewById(R.id.friday);
                t.setText("Friday, " + getMonth(array[1]+1) + "4");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]+1) + "5");
                return;
            }
            else //Tuesday continues the current month
            {
                t.setText("Tuesday, " + getMonth(array[1]) + (array[4]+2));
            }
            t = (TextView) findViewById(R.id.wednesday);
            if(array[4]+3 > array[5]) // if the month ends on Tuesday, Wednesday is the 1st of next month
            {
                t.setText("Wednesday, " + getMonth(array[1]+1) + "1");
                t = (TextView) findViewById(R.id.thursday);
                t.setText("Thursday, " + getMonth(array[1]+1) + "2");
                t = (TextView) findViewById(R.id.friday);
                t.setText("Friday, " + getMonth(array[1]+1) + "3");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]+1) + "4");
                return;
            }
            else //Wednesday continues the current month
            {
                t.setText("Wednesday, " + getMonth(array[1]) + (array[4]+3));
            }
            t = (TextView) findViewById(R.id.thursday);
            if(array[4]+4 > array[5]) // if the month ends on Wednesday, Thursday is the 1st of next month
            {
                t.setText("Thursday, " + getMonth(array[1]+1) + "1");
                t = (TextView) findViewById(R.id.friday);
                t.setText("Friday, " + getMonth(array[1]+1) + "2");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]+1) + "3");
                return;
            }
            else //Thursday continues the current month
            {
                t.setText("Thursday, " + getMonth(array[1]) + (array[4]+4));
            }
            t = (TextView) findViewById(R.id.friday);
            if(array[4]+5 > array[5]) // if the month ends on Thursday, Friday is the 1st of next month
            {
                t.setText("Friday, " + getMonth(array[1]+1) + "1");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]+1) + "2");
                return;
            }
            else //Friday continues the current month
            {
                t.setText("Friday, " + getMonth(array[1]) + (array[4]+5));
            }
            t = (TextView) findViewById(R.id.saturday);
            t.setText("Saturday, " + getMonth(array[1]+1) + "1"); // otherwise, Saturday must begin the next month
        }
        else if(array[7] == 6) //Week 6
        {
            t.setText("Sunday, " + getMonth(array[1]) + array[4]);
            t = (TextView) findViewById(R.id.monday);
            if(array[4]+1 <= array[5]) // if month ends on Monday, Tuesday is the 1st
            {
                t.setText("Monday, " + getMonth(array[1]) + (array[4]+1));
                t = (TextView) findViewById(R.id.tuesday);
                t.setText("Tuesday, " + getMonth(array[1]+1) + "1");
                t = (TextView) findViewById(R.id.wednesday);
                t.setText("Wednesday, " + getMonth(array[1]+1) + "2");
                t = (TextView) findViewById(R.id.thursday);
                t.setText("Thursday, " + getMonth(array[1]+1) + "3");
                t = (TextView) findViewById(R.id.friday);
                t.setText("Friday, " + getMonth(array[1]+1) + "4");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]+1) + "5");
            }
            else // otherwise, the month must end on Sunday, Monday is the 1st
            {
                t.setText("Monday, " + getMonth(array[1]+1) + "1");
                t = (TextView) findViewById(R.id.tuesday);
                t.setText("Tuesday, " + getMonth(array[1]+1) + "2");
                t = (TextView) findViewById(R.id.wednesday);
                t.setText("Wednesday, " + getMonth(array[1]+1) + "3");
                t = (TextView) findViewById(R.id.thursday);
                t.setText("Thursday, " + getMonth(array[1]+1) + "4");
                t = (TextView) findViewById(R.id.friday);
                t.setText("Friday, " + getMonth(array[1]+1) + "5");
                t = (TextView) findViewById(R.id.saturday);
                t.setText("Saturday, " + getMonth(array[1]+1) + "6");
            }
        }
        else //Middle week can continue with no month switching
        {
            t.setText("Sunday, " + getMonth(array[1]) + array[4]);
            t = (TextView) findViewById(R.id.monday);
            t.setText("Monday, " + getMonth(array[1]) + (array[4]+1));
            t = (TextView) findViewById(R.id.tuesday);
            t.setText("Tuesday, " + getMonth(array[1]) + (array[4]+2));
            t = (TextView) findViewById(R.id.wednesday);
            t.setText("Wednesday, " + getMonth(array[1]) + (array[4]+3));
            t = (TextView) findViewById(R.id.thursday);
            t.setText("Thursday, " + getMonth(array[1]) + (array[4]+4));
            t = (TextView) findViewById(R.id.friday);
            t.setText("Friday, " + getMonth(array[1]) + (array[4]+5));
            t = (TextView) findViewById(R.id.saturday);
            t.setText("Saturday, " + getMonth(array[1]) + (array[4]+6));
        }
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putIntArray(DATA, array);
        super.onSaveInstanceState(savedInstanceState);
    }
}
