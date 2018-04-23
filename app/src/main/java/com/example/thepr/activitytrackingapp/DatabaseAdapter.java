package com.example.thepr.activitytrackingapp;

/**
 * Created by thepr on 4/16/2018.
 */

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import android.content.ContentValues;



public class DatabaseAdapter {
    private static final String DATABASE_NAME = "MyRunsDB";
    private static final String TABLE_NAME_ENTRIES ="entries";

    private static final int DATABASE_VERSION = 1;


    public static final String KEY__ROWID = Globals.KEY__ROWID; // "_id";
    public static final String KEY_INPUT_TYPE =Globals.KEY_INPUT_TYPE; // "input_type";
    public static final String KEY_ACTIVITY_TYPE = Globals.KEY_ACTIVITY_TYPE; //"activity_type";
    public static final String KEY_DATE_TYPE = Globals.KEY_DATE_TYPE; //"date_time";
    public static final String KEY_DURATION =  Globals.KEY_DURATION; //"duration";
    public static final String KEY_DISTANCE = Globals.KEY_DISTANCE; //"distance";
    public static final String KEY_CALORIES = Globals.KEY_CALORIES; //"calories";
    public static final String KEY_COMMENT = Globals.KEY_COMMENT; //"comment";




    private static final String CREATE_TABLE_ENTRIES = "CREATE TABLE IF NOT EXISTS "
            + "entries(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "input_type INTEGER NOT NULL, "
            + "activity_type TEXT NOT NULL, "
            + "date_time TEXT NOT NULL, "
            + "duration INTEGER NOT NULL, "
            + "distance FLOAT, "
            + "calories INTEGER, "
            + "comment TEXT " + ");";

    private Context mContext;


    //Variable to hol the database instance
    private SQLiteDatabase db;
    //Context of the application using the database
    //private final Context context;
    //Database open/upgrade helper

    private DBHelper dbHelper;
    //private final Context context;

    public DatabaseAdapter(Context context){
        dbHelper = new DBHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor fetchEntries(){
       return db.query(TABLE_NAME_ENTRIES, new String[] {KEY__ROWID, KEY_INPUT_TYPE, KEY_ACTIVITY_TYPE, KEY_DATE_TYPE, KEY_DURATION, KEY_DISTANCE, KEY_CALORIES, KEY_COMMENT}, null, null, null, null, null);

    }

/* public DatabaseAdapter open() throws SQLException {
		dbHelper = new DBHelper(mContext, DATABASE_NAME, null, DATABASE_VERSION);
			 db = dbHelper.getWritableDatabase();
			  return this;
		   }  */

    //---opens the database---





    public long insertEntry(int input_type1, String activity_type1, String date_time1, int mDuration1, double mDistance1, int mCalories1, String mComment1){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_INPUT_TYPE, input_type1);
        initialValues.put(KEY_ACTIVITY_TYPE, activity_type1);
        initialValues.put(KEY_DATE_TYPE, date_time1);
        initialValues.put(KEY_DURATION, mDuration1);
        initialValues.put(KEY_DISTANCE, mDistance1);
        initialValues.put(KEY_CALORIES, mCalories1);
        initialValues.put(KEY_COMMENT, mComment1);

        return db.insert(TABLE_NAME_ENTRIES, null, initialValues);
    }





    private static class DBHelper extends SQLiteOpenHelper {


        public DBHelper(Context context, String name, CursorFactory factory, int version) {

            super(context, name, factory, version);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            // TODO Auto-generated method stub
            try{
                db.execSQL(CREATE_TABLE_ENTRIES);
            }catch(SQLException e){
                e.printStackTrace();

            }


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

        }








    }


    public DatabaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    //---closes the database---
    public void close()
    {
        dbHelper.close();
    }


}
