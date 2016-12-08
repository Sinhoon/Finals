

package eecs448_first_team.calender_app;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class MonthView extends AppCompatActivity implements View.OnClickListener {
    public final static String DATA = "";
    public int[] array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_view);

        findViewById(R.id.yearButton).setOnClickListener(this);
        findViewById(R.id.firstWeek).setOnClickListener(this);
        findViewById(R.id.secondWeek).setOnClickListener(this);
        findViewById(R.id.thirdWeek).setOnClickListener(this);
        findViewById(R.id.fourthWeek).setOnClickListener(this);
        findViewById(R.id.fifthWeek).setOnClickListener(this);
        findViewById(R.id.sixthWeek).setOnClickListener(this);

        Intent getToMonth = getIntent();
        array = getToMonth.getIntArrayExtra(YearDisplay.DATA);
        array = getToMonth.getIntArrayExtra(WeekView.DATA);


        if(array[1] != 0)
        {
            TextView textview = (TextView) findViewById(R.id.monthName);
            textview.setText(getMonth(array[1]));
        }
        if(array[3] != 0 && array[5] != 0) // if array contains the day of the 1st of the month and the number of days in the month, fill out the xml
        {
            fillMonth(array[3], array[5]);
        }
    }
    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case (R.id.yearButton):
            {
                Intent goToYear = new Intent(this, YearDisplay.class);
                startActivity(goToYear);
                break;
            }
            case (R.id.firstWeek):
            {
                if(array[3] == 1) // if 1st day of month is Sunday
                {
                    array[4] = 1; // the date of Sunday is the 1st
                }
                else if(array[6] == 31) // if the previous month had 31 days (the previous month is in the first week)
                {
                    array[4] = 33-array[3]; // the date of Sunday is 33-(date of the 1st of the month)
                }
                else if(array[6] == 30) // if the previous month had 30 days (the previous month is in the first week)
                {
                    array[4] = 32-array[3]; // the date of Sunday is 32-(date of the 1st of the month)
                }
                else if(array[6] == 28) // if February was the previous month
                {
                    array[4] = 30-array[3]; // the date of Sunday is 30-(date of the 1st of the month)
                }
                array[7] = 1; // this is the first week
                Intent goToWeek = new Intent(this, WeekView.class);
                goToWeek.putExtra(DATA, array);
                startActivity(goToWeek);
                break;
            }
            case(R.id.secondWeek):
            {
                if(array[3] == 1) // if Sunday is the first day of the month
                {
                    array[4] = 8; // Sunday is the 8th
                }
                else if(array[3] == 2) // if Monday is the first day of the month
                {
                    array[4] = 7; // Sunday is the 7th
                }
                else if(array[3] == 3) // if Tuesday is the first day of the month
                {
                    array[4] = 6; // Sunday is the 6th
                }
                else if(array[3] == 4) // if Wednesday is the first day of the month
                {
                    array[4] = 5; // Sunday is the 5th
                }
                else if(array[3] == 5) // if Thursday is the first day of the month
                {
                    array[4] = 4; // Sunday is the 4th
                }
                else if(array[3] == 6) // if Friday is the first day of the month
                {
                    array[4] = 3; // Sunday is the 3rd
                }
                else if(array[3] == 7) // if Saturday is the first day of the month
                {
                    array[4] = 2; // Sunday is the 2nd
                }
                array[7] = 2; // this is the second week
                Intent goToWeek = new Intent(this, WeekView.class);
                goToWeek.putExtra(DATA, array);
                startActivity(goToWeek);
                break;
            }
            case(R.id.thirdWeek):
            {
                //See previous cases
                if(array[3] == 1)
                {
                    array[4] = 15;
                }
                else if(array[3] == 2)
                {
                    array[4] = 14;
                }
                else if(array[3] == 3)
                {
                    array[4] = 13;
                }
                else if(array[3] == 4)
                {
                    array[4] = 12;
                }
                else if(array[3] == 5)
                {
                    array[4] = 11;
                }
                else if(array[3] == 6)
                {
                    array[4] = 10;
                }
                else if(array[3] == 7)
                {
                    array[4] = 9;
                }
                array[7] = 3; // this is the third week
                Intent goToWeek = new Intent(this, WeekView.class);
                goToWeek.putExtra(DATA, array);
                startActivity(goToWeek);
                break;
            }
            case(R.id.fourthWeek):
            {
                //See previous cases
                if(array[3] == 1)
                {
                    array[4] = 22;
                }
                else if(array[3] == 2)
                {
                    array[4] = 21;
                }
                else if(array[3] == 3)
                {
                    array[4] = 20;
                }
                else if(array[3] == 4)
                {
                    array[4] = 19;
                }
                else if(array[3] == 5)
                {
                    array[4] = 18;
                }
                else if(array[3] == 6)
                {
                    array[4] = 17;
                }
                else if(array[3] == 7)
                {
                    array[4] = 16;
                }
                array[7] = 4; //This is the fourth week
                Intent goToWeek = new Intent(this, WeekView.class);
                goToWeek.putExtra(DATA, array);
                startActivity(goToWeek);
                break;
            }
            case(R.id.fifthWeek):
            {
                //See previous cases
                if(array[3] == 1 && array[5] >= 29) // also if there are at least 29 days in the month
                {
                    array[4] = 29;
                }
                else if(array[3] == 2)
                {
                    array[4] = 28;
                }
                else if(array[3] == 3)
                {
                    array[4] = 27;
                }
                else if(array[3] == 4)
                {
                    array[4] = 26;
                }
                else if(array[3] == 5)
                {
                    array[4] = 25;
                }
                else if(array[3] == 6)
                {
                    array[4] = 24;
                }
                else if(array[3] == 7)
                {
                    array[4] = 23;
                }
                array[7] = 5; // this is the fifth week
                Intent goToWeek = new Intent(this, WeekView.class);
                goToWeek.putExtra(DATA, array);
                startActivity(goToWeek);
                break;
            }
            case(R.id.sixthWeek):
            {
                if(array[3] == 6 && array[5] == 31) // if the 1st day of the month was Friday and there are 31 days in the month
                {
                    array[4] = 31; // Sunday will be the 31st
                    array[7] = 6; // this is the sixth week
                    Intent goToWeek = new Intent(this, WeekView.class);
                    goToWeek.putExtra(DATA, array);
                    startActivity(goToWeek);
                }
                else if(array[3] == 7 && array[5] >= 30) // if the 1st day of the month was Saturday and there are at least 30 days in the month
                {
                    array[4] = 30; // Sunday will be the 30th
                    array[7] = 6; // this is the sixth week
                    Intent goToWeek = new Intent(this, WeekView.class);
                    goToWeek.putExtra(DATA, array);
                    startActivity(goToWeek);
                }
                break;
            }
        }
    }


    public String getMonth(int m)
    {
        if(m == 8)
        {
            return("August");
        }
        else if(m == 9)
        {
            return("September");
        }
        else if(m == 10)
        {
            return("October");
        }
        else if(m == 11)
        {
            return("November");
        }
        else if(m == 12)
        {
            return("December");
        }
        else if(m == 1)
        {
            return("January");
        }
        else if(m == 2)
        {
            return("February");
        }
        else if(m == 3)
        {
            return("March");
        }
        else if(m == 4)
        {
            return("April");
        }
        else if(m == 5)
        {
            return("May");
        }
        else
        {
            return("");
        }
    }


    public void fillMonth(int start, int end)
    {

        if(start == 1) // if Sunday was the 1st day of the month
        {
            TextView t = (TextView) findViewById(R.id.w11);
            t.setText("01");
            t = (TextView) findViewById(R.id.w12);
            t.setText("02");
            t = (TextView) findViewById(R.id.w13);
            t.setText("03");
            t = (TextView) findViewById(R.id.w14);
            t.setText("04");
            t = (TextView) findViewById(R.id.w15);
            t.setText("05");
            t = (TextView) findViewById(R.id.w16);
            t.setText("06");
            t = (TextView) findViewById(R.id.w17);
            t.setText("07");
            t = (TextView) findViewById(R.id.w21);
            t.setText("08");
            t = (TextView) findViewById(R.id.w22);
            t.setText("09");
            t = (TextView) findViewById(R.id.w23);
            t.setText("10");
            t = (TextView) findViewById(R.id.w24);
            t.setText("11");
            t = (TextView) findViewById(R.id.w25);
            t.setText("12");
            t = (TextView) findViewById(R.id.w26);
            t.setText("13");
            t = (TextView) findViewById(R.id.w27);
            t.setText("14");
            t = (TextView) findViewById(R.id.w31);
            t.setText("15");
            t = (TextView) findViewById(R.id.w32);
            t.setText("16");
            t = (TextView) findViewById(R.id.w33);
            t.setText("17");
            t = (TextView) findViewById(R.id.w34);
            t.setText("18");
            t = (TextView) findViewById(R.id.w35);
            t.setText("19");
            t = (TextView) findViewById(R.id.w36);
            t.setText("20");
            t = (TextView) findViewById(R.id.w37);
            t.setText("21");
            t = (TextView) findViewById(R.id.w41);
            t.setText("22");
            t = (TextView) findViewById(R.id.w42);
            t.setText("23");
            t = (TextView) findViewById(R.id.w43);
            t.setText("24");
            t = (TextView) findViewById(R.id.w44);
            t.setText("25");
            t = (TextView) findViewById(R.id.w45);
            t.setText("26");
            t = (TextView) findViewById(R.id.w46);
            t.setText("27");
            t = (TextView) findViewById(R.id.w47);
            t.setText("28");
            if(end != 28) // if more than 28 days in the month
            {
                t = (TextView) findViewById(R.id.w51);
                t.setText("29");
                t = (TextView) findViewById(R.id.w52);
                t.setText("30");
                if (end == 31) // if more than 30 days in the month
                {
                    t = (TextView) findViewById(R.id.w53);
                    t.setText("31");
                }
            }
        }
        else if(start == 2) // if Monday was the 1st of the month
        {
            TextView t = (TextView) findViewById(R.id.w12);
            t.setText("01");
            t = (TextView) findViewById(R.id.w13);
            t.setText("02");
            t = (TextView) findViewById(R.id.w14);
            t.setText("03");
            t = (TextView) findViewById(R.id.w15);
            t.setText("04");
            t = (TextView) findViewById(R.id.w16);
            t.setText("05");
            t = (TextView) findViewById(R.id.w17);
            t.setText("06");
            t = (TextView) findViewById(R.id.w21);
            t.setText("07");
            t = (TextView) findViewById(R.id.w22);
            t.setText("08");
            t = (TextView) findViewById(R.id.w23);
            t.setText("09");
            t = (TextView) findViewById(R.id.w24);
            t.setText("10");
            t = (TextView) findViewById(R.id.w25);
            t.setText("11");
            t = (TextView) findViewById(R.id.w26);
            t.setText("12");
            t = (TextView) findViewById(R.id.w27);
            t.setText("13");
            t = (TextView) findViewById(R.id.w31);
            t.setText("14");
            t = (TextView) findViewById(R.id.w32);
            t.setText("15");
            t = (TextView) findViewById(R.id.w33);
            t.setText("16");
            t = (TextView) findViewById(R.id.w34);
            t.setText("17");
            t = (TextView) findViewById(R.id.w35);
            t.setText("18");
            t = (TextView) findViewById(R.id.w36);
            t.setText("19");
            t = (TextView) findViewById(R.id.w37);
            t.setText("20");
            t = (TextView) findViewById(R.id.w41);
            t.setText("21");
            t = (TextView) findViewById(R.id.w42);
            t.setText("22");
            t = (TextView) findViewById(R.id.w43);
            t.setText("23");
            t = (TextView) findViewById(R.id.w44);
            t.setText("24");
            t = (TextView) findViewById(R.id.w45);
            t.setText("25");
            t = (TextView) findViewById(R.id.w46);
            t.setText("26");
            t = (TextView) findViewById(R.id.w47);
            t.setText("27");
            t = (TextView) findViewById(R.id.w51);
            t.setText("28");
            if(end != 28) // if more than 28 days in the month
            {
                t = (TextView) findViewById(R.id.w52);
                t.setText("29");
                t = (TextView) findViewById(R.id.w53);
                t.setText("30");
                if (end == 31)  // if more than 30 days in the month
                {
                    t = (TextView) findViewById(R.id.w54);
                    t.setText("31");
                }
            }
        }
        else if(start == 3)  // if Tuesday was the 1st of the month
        {
            TextView t = (TextView) findViewById(R.id.w13);
            t.setText("01");
            t = (TextView) findViewById(R.id.w14);
            t.setText("02");
            t = (TextView) findViewById(R.id.w15);
            t.setText("03");
            t = (TextView) findViewById(R.id.w16);
            t.setText("04");
            t = (TextView) findViewById(R.id.w17);
            t.setText("05");
            t = (TextView) findViewById(R.id.w21);
            t.setText("06");
            t = (TextView) findViewById(R.id.w22);
            t.setText("07");
            t = (TextView) findViewById(R.id.w23);
            t.setText("08");
            t = (TextView) findViewById(R.id.w24);
            t.setText("09");
            t = (TextView) findViewById(R.id.w25);
            t.setText("10");
            t = (TextView) findViewById(R.id.w26);
            t.setText("11");
            t = (TextView) findViewById(R.id.w27);
            t.setText("12");
            t = (TextView) findViewById(R.id.w31);
            t.setText("13");
            t = (TextView) findViewById(R.id.w32);
            t.setText("14");
            t = (TextView) findViewById(R.id.w33);
            t.setText("15");
            t = (TextView) findViewById(R.id.w34);
            t.setText("16");
            t = (TextView) findViewById(R.id.w35);
            t.setText("17");
            t = (TextView) findViewById(R.id.w36);
            t.setText("18");
            t = (TextView) findViewById(R.id.w37);
            t.setText("19");
            t = (TextView) findViewById(R.id.w41);
            t.setText("20");
            t = (TextView) findViewById(R.id.w42);
            t.setText("21");
            t = (TextView) findViewById(R.id.w43);
            t.setText("22");
            t = (TextView) findViewById(R.id.w44);
            t.setText("23");
            t = (TextView) findViewById(R.id.w45);
            t.setText("24");
            t = (TextView) findViewById(R.id.w46);
            t.setText("25");
            t = (TextView) findViewById(R.id.w47);
            t.setText("26");
            t = (TextView) findViewById(R.id.w51);
            t.setText("27");
            t = (TextView) findViewById(R.id.w52);
            t.setText("28");
            if(end != 28) // if more than 28 days in the month
            {
                t = (TextView) findViewById(R.id.w53);
                t.setText("29");
                t = (TextView) findViewById(R.id.w54);
                t.setText("30");
                if (end == 31)  // if more than 30 days in the month
                {
                    t = (TextView) findViewById(R.id.w55);
                    t.setText("31");
                }
            }
        }
        else if(start == 4)  // if Wednesday was the 1st of the month
        {
            TextView t = (TextView) findViewById(R.id.w14);
            t.setText("01");
            t = (TextView) findViewById(R.id.w15);
            t.setText("02");
            t = (TextView) findViewById(R.id.w16);
            t.setText("03");
            t = (TextView) findViewById(R.id.w17);
            t.setText("04");
            t = (TextView) findViewById(R.id.w21);
            t.setText("05");
            t = (TextView) findViewById(R.id.w22);
            t.setText("06");
            t = (TextView) findViewById(R.id.w23);
            t.setText("07");
            t = (TextView) findViewById(R.id.w24);
            t.setText("08");
            t = (TextView) findViewById(R.id.w25);
            t.setText("09");
            t = (TextView) findViewById(R.id.w26);
            t.setText("10");
            t = (TextView) findViewById(R.id.w27);
            t.setText("11");
            t = (TextView) findViewById(R.id.w31);
            t.setText("12");
            t = (TextView) findViewById(R.id.w32);
            t.setText("13");
            t = (TextView) findViewById(R.id.w33);
            t.setText("14");
            t = (TextView) findViewById(R.id.w34);
            t.setText("15");
            t = (TextView) findViewById(R.id.w35);
            t.setText("16");
            t = (TextView) findViewById(R.id.w36);
            t.setText("17");
            t = (TextView) findViewById(R.id.w37);
            t.setText("18");
            t = (TextView) findViewById(R.id.w41);
            t.setText("19");
            t = (TextView) findViewById(R.id.w42);
            t.setText("20");
            t = (TextView) findViewById(R.id.w43);
            t.setText("21");
            t = (TextView) findViewById(R.id.w44);
            t.setText("22");
            t = (TextView) findViewById(R.id.w45);
            t.setText("23");
            t = (TextView) findViewById(R.id.w46);
            t.setText("24");
            t = (TextView) findViewById(R.id.w47);
            t.setText("25");
            t = (TextView) findViewById(R.id.w51);
            t.setText("26");
            t = (TextView) findViewById(R.id.w52);
            t.setText("27");
            t = (TextView) findViewById(R.id.w53);
            t.setText("28");
            if(end != 28) // if more than 28 days in the month
            {
                t = (TextView) findViewById(R.id.w54);
                t.setText("29");
                t = (TextView) findViewById(R.id.w55);
                t.setText("30");
                if (end == 31)  // if more than 30 days in the month
                {
                    t = (TextView) findViewById(R.id.w56);
                    t.setText("31");
                }
            }
        }
        else if(start == 5)  // if Thursday was the 1st of the month
        {
            TextView t = (TextView) findViewById(R.id.w15);
            t.setText("01");
            t = (TextView) findViewById(R.id.w16);
            t.setText("02");
            t = (TextView) findViewById(R.id.w17);
            t.setText("03");
            t = (TextView) findViewById(R.id.w21);
            t.setText("04");
            t = (TextView) findViewById(R.id.w22);
            t.setText("05");
            t = (TextView) findViewById(R.id.w23);
            t.setText("06");
            t = (TextView) findViewById(R.id.w24);
            t.setText("07");
            t = (TextView) findViewById(R.id.w25);
            t.setText("08");
            t = (TextView) findViewById(R.id.w26);
            t.setText("09");
            t = (TextView) findViewById(R.id.w27);
            t.setText("10");
            t = (TextView) findViewById(R.id.w31);
            t.setText("11");
            t = (TextView) findViewById(R.id.w32);
            t.setText("12");
            t = (TextView) findViewById(R.id.w33);
            t.setText("13");
            t = (TextView) findViewById(R.id.w34);
            t.setText("14");
            t = (TextView) findViewById(R.id.w35);
            t.setText("15");
            t = (TextView) findViewById(R.id.w36);
            t.setText("16");
            t = (TextView) findViewById(R.id.w37);
            t.setText("17");
            t = (TextView) findViewById(R.id.w41);
            t.setText("18");
            t = (TextView) findViewById(R.id.w42);
            t.setText("19");
            t = (TextView) findViewById(R.id.w43);
            t.setText("20");
            t = (TextView) findViewById(R.id.w44);
            t.setText("21");
            t = (TextView) findViewById(R.id.w45);
            t.setText("22");
            t = (TextView) findViewById(R.id.w46);
            t.setText("23");
            t = (TextView) findViewById(R.id.w47);
            t.setText("24");
            t = (TextView) findViewById(R.id.w51);
            t.setText("25");
            t = (TextView) findViewById(R.id.w52);
            t.setText("26");
            t = (TextView) findViewById(R.id.w53);
            t.setText("27");
            t = (TextView) findViewById(R.id.w54);
            t.setText("28");
            if(end != 28) // if more than 28 days in the month
            {
                t = (TextView) findViewById(R.id.w55);
                t.setText("29");
                t = (TextView) findViewById(R.id.w56);
                t.setText("30");
                if (end == 31)  // if more than 30 days in the month
                {
                    t = (TextView) findViewById(R.id.w57);
                    t.setText("31");
                }
            }
        }
        else if(start == 6) // if Friday was the 1st of the month
        {
            TextView t = (TextView) findViewById(R.id.w16);
            t.setText("01");
            t = (TextView) findViewById(R.id.w17);
            t.setText("02");
            t = (TextView) findViewById(R.id.w21);
            t.setText("03");
            t = (TextView) findViewById(R.id.w22);
            t.setText("04");
            t = (TextView) findViewById(R.id.w23);
            t.setText("05");
            t = (TextView) findViewById(R.id.w24);
            t.setText("06");
            t = (TextView) findViewById(R.id.w25);
            t.setText("07");
            t = (TextView) findViewById(R.id.w26);
            t.setText("08");
            t = (TextView) findViewById(R.id.w27);
            t.setText("09");
            t = (TextView) findViewById(R.id.w31);
            t.setText("10");
            t = (TextView) findViewById(R.id.w32);
            t.setText("11");
            t = (TextView) findViewById(R.id.w33);
            t.setText("12");
            t = (TextView) findViewById(R.id.w34);
            t.setText("13");
            t = (TextView) findViewById(R.id.w35);
            t.setText("14");
            t = (TextView) findViewById(R.id.w36);
            t.setText("15");
            t = (TextView) findViewById(R.id.w37);
            t.setText("16");
            t = (TextView) findViewById(R.id.w41);
            t.setText("17");
            t = (TextView) findViewById(R.id.w42);
            t.setText("18");
            t = (TextView) findViewById(R.id.w43);
            t.setText("19");
            t = (TextView) findViewById(R.id.w44);
            t.setText("20");
            t = (TextView) findViewById(R.id.w45);
            t.setText("21");
            t = (TextView) findViewById(R.id.w46);
            t.setText("22");
            t = (TextView) findViewById(R.id.w47);
            t.setText("23");
            t = (TextView) findViewById(R.id.w51);
            t.setText("24");
            t = (TextView) findViewById(R.id.w52);
            t.setText("25");
            t = (TextView) findViewById(R.id.w53);
            t.setText("26");
            t = (TextView) findViewById(R.id.w54);
            t.setText("27");
            t = (TextView) findViewById(R.id.w55);
            t.setText("28");
            if(end != 28) // if more than 28 days in the month
            {
                t = (TextView) findViewById(R.id.w56);
                t.setText("29");
                t = (TextView) findViewById(R.id.w57);
                t.setText("30");
                if (end == 31)  // if more than 30 days in the month
                {
                    t = (TextView) findViewById(R.id.w61);
                    t.setText("31");
                }
            }
        }
        else if(start == 7) // if Saturday was the 1st of the month
        {
            TextView t = (TextView) findViewById(R.id.w17);
            t.setText("01");
            t = (TextView) findViewById(R.id.w21);
            t.setText("02");
            t = (TextView) findViewById(R.id.w22);
            t.setText("03");
            t = (TextView) findViewById(R.id.w23);
            t.setText("04");
            t = (TextView) findViewById(R.id.w24);
            t.setText("05");
            t = (TextView) findViewById(R.id.w25);
            t.setText("06");
            t = (TextView) findViewById(R.id.w26);
            t.setText("07");
            t = (TextView) findViewById(R.id.w27);
            t.setText("08");
            t = (TextView) findViewById(R.id.w31);
            t.setText("09");
            t = (TextView) findViewById(R.id.w32);
            t.setText("10");
            t = (TextView) findViewById(R.id.w33);
            t.setText("11");
            t = (TextView) findViewById(R.id.w34);
            t.setText("12");
            t = (TextView) findViewById(R.id.w35);
            t.setText("13");
            t = (TextView) findViewById(R.id.w36);
            t.setText("14");
            t = (TextView) findViewById(R.id.w37);
            t.setText("15");
            t = (TextView) findViewById(R.id.w41);
            t.setText("16");
            t = (TextView) findViewById(R.id.w42);
            t.setText("17");
            t = (TextView) findViewById(R.id.w43);
            t.setText("18");
            t = (TextView) findViewById(R.id.w44);
            t.setText("19");
            t = (TextView) findViewById(R.id.w45);
            t.setText("20");
            t = (TextView) findViewById(R.id.w46);
            t.setText("21");
            t = (TextView) findViewById(R.id.w47);
            t.setText("22");
            t = (TextView) findViewById(R.id.w51);
            t.setText("23");
            t = (TextView) findViewById(R.id.w52);
            t.setText("24");
            t = (TextView) findViewById(R.id.w53);
            t.setText("25");
            t = (TextView) findViewById(R.id.w54);
            t.setText("26");
            t = (TextView) findViewById(R.id.w55);
            t.setText("27");
            t = (TextView) findViewById(R.id.w56);
            t.setText("28");
            if(end != 28) // if more than 28 days in the month
            {
                t = (TextView) findViewById(R.id.w57);
                t.setText("29");
                t = (TextView) findViewById(R.id.w61);
                t.setText("30");
                if (end == 31)  // if more than 30 days in the month
                {
                    t = (TextView) findViewById(R.id.w62);
                    t.setText("31");
                }
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putIntArray(DATA, array);
        super.onSaveInstanceState(savedInstanceState);
    }
}
