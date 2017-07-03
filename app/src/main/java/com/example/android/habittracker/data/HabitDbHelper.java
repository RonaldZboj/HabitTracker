package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.data.HabitContract.HabitEntry;

public class HabitDbHelper extends SQLiteOpenHelper {

    // Database helper for access to the database
    private HabitDbHelper mDbHelper;


    private static final String DATABASE_NAME = "habits.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_HABIT_TABLE =
            "CREATE TABLE " + HabitEntry.TABLE_NAME + " (" +
                    HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL," +
                    HabitEntry.COLUMN_HABIT_HOW_MANY_TIMES + " INTEGER NOT NULL," +
                    HabitEntry.COLUMN_HABIT_WHAT_TIME_PERIOD + " INTEGER NOT NULL)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME;


    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public static void insertHabit(SQLiteDatabase db) {

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "Violin");
        values.put(HabitEntry.COLUMN_HABIT_HOW_MANY_TIMES, 5);
        values.put(HabitEntry.COLUMN_HABIT_WHAT_TIME_PERIOD, HabitEntry.WHAT_TIME_PERIOD_DAY);

        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    public static Cursor DisplayDatabaseInfo(SQLiteDatabase db) {


        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_HOW_MANY_TIMES,
                HabitEntry.COLUMN_HABIT_WHAT_TIME_PERIOD
        };

        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME,        // table
                projection,                   // columns
                null,                         // columns for WHERE
                null,                         // values for WHERE
                null,                         // don't group the rows
                null,                         // don't filter by row groups
                null                          // The sort order
        );

        cursor.moveToFirst();

        // Return the first row from database (all column)
        return cursor;
    }

}
