package eecs448_first_team.calender_app;



import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements CalendarView.OnDateChangeListener{

    CalendarView calendarView;
    Calendar interpreterCalendar;
    CalendarEventDb editDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        interpreterCalendar = Calendar.getInstance();
        interpreterCalendar.set(Calendar.HOUR,0); //locks hours,minutes,seconds,MS in Calendar to 0 to make consistent, and so we don't have to zero them again later
        interpreterCalendar.set(Calendar.MINUTE,0); //thus, I can say with certainty that using the Calendar to convert 9-21-2016 to milliseconds will produce a constant value
        interpreterCalendar.set(Calendar.SECOND,0);
        interpreterCalendar.set(Calendar.MILLISECOND,0);

}

    @Override
    public void onResume()
    {
        super.onResume();
        editDatabase = new CalendarEventDb(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onPause()
    {
        super.onPause();
        editDatabase.close();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
        interpreterCalendar.set(year,month,dayOfMonth); //Calendar created by Calendar.getInstance();
        calendarView.setDate(interpreterCalendar.getTimeInMillis()); //the CalendarView
        Long outVal = view.getDate();
        Toast.makeText(this,"Date " + dayOfMonth + "-" + month + "-" + year,Toast.LENGTH_LONG).show();
    }
}
