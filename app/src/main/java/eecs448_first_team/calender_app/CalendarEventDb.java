package eecs448_first_team.calender_app;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.Calendar;


public class CalendarEventDb extends SQLiteOpenHelper
{
    private class CalendarEvent
    {
        private Long ID;
        private String details;
        private Long daySinceAugustFirst_2016; 

        public void setDetails(String newDetails) {details = newDetails;}
        public String getDetails() {return details;}

        public void setID(Long newId) {ID = newId;}
        public Long getID() {return ID;}

        public Long getDaySinceAugustFirst_2016() {return daySinceAugustFirst_2016;}
        public void setDaySinceAugustFirst_2016(Long newValue) {daySinceAugustFirst_2016 = newValue;}
    }

    private SQLiteDatabase rdb; 
    private SQLiteDatabase wdb; 
	public static final int DATABASE_VER = 1; 
	private static final String DATABASE_NAME = "CalendarEventTable.db";
    private Calendar timeCalendar;
    private class CalendarEventTable implements BaseColumns
    {
        
        static final String Column_Details = "Details";
        static final String Column_Date = "Date";
    }


    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + CalendarEventTable.Table_Name
            + " (" + CalendarEventTable._ID + " INTEGER PRIMARY KEY," + CalendarEventTable.Column_Details + " TEXT," + CalendarEventTable.Column_Date + " INTEGER )";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + CalendarEventTable.Table_Name;
    private static final String[] PARAMETERS_TABLE_RETURN_COLUMNS = {CalendarEventTable._ID,CalendarEventTable.Column_Date,CalendarEventTable.Column_Details};
    private static final String[] PARAMETERS_TABLE_SEARCH_COLUMNS_DATE = {CalendarEventTable.Column_Date};
	public CalendarEventDb(Context context)
	{
		super(context,DATABASE_NAME,null,DATABASE_VER);
	}
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(SQL_CREATE_ENTRIES);
	}


	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL(SQL_DELETE_ENTRIES);
		onCreate(db);
	}

    public String getCalendarDetails(Long timeInMilliseconds)
    {
        if(rdb == null)
            rdb = this.getReadableDatabase();
        String[] searchArgs = {timeInMilliseconds.toString()};
        try
        {
            CalendarEvent matchingEvent = getCalendarEvent(timeInMilliseconds);
            if(matchingEvent != null)
            {
                return matchingEvent.getDetails();
            }
            else
                return "";
        }
        catch(Exception e)
        {
            return "";
        }

    }


    public CalendarEvent getCalendarEvent(Long timeInMilliseconds)
    {
        if(rdb == null)
            rdb = this.getReadableDatabase();
        String[] searchArgs = {timeInMilliseconds.toString()};
        try
        {
            Cursor searchContainer = rdb.query(
                    CalendarEventTable.Table_Name, 
                    PARAMETERS_TABLE_RETURN_COLUMNS, .
                    CalendarEventTable.Column_Date + "=?",
                    searchArgs, 
                    null,
                    null,
                    CalendarEventTable.Column_Date 
            );

            if(searchContainer.getCount() >= 1)
            {
                searchContainer.moveToFirst();
                CalendarEvent returnCalendarEvent = new CalendarEvent();
                returnCalendarEvent.setDetails(searchContainer.getString(2));
                returnCalendarEvent.setID(searchContainer.getLong(0));
                returnCalendarEvent.setDaySinceAugustFirst_2016(searchContainer.getLong(1));
                if(returnCalendarEvent != null)
                    return returnCalendarEvent;
                else
                    return null;
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            return null;
        }

    }


    public boolean setCalendarDetails(Long timeInMilliseconds,String detailsForDay)
    {
        if(wdb == null)
            wdb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CalendarEventTable.Column_Date,timeInMilliseconds);
        CalendarEvent matchingEvent = getCalendarEvent(timeInMilliseconds);
        if(matchingEvent != null)
        {
            values.put(CalendarEventTable._ID,matchingEvent.getID());
        }
        values.put(CalendarEventTable.Column_Details,detailsForDay);
        try
        {

            wdb.replace(CalendarEventTable.Table_Name,null,values);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{

		onUpgrade(db,oldVersion,newVersion);
	}


}
