package com.example.android.habittracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.habittracker.data.HabitDbHelper;

import static com.example.android.habittracker.data.HabitDbHelper.DisplayDatabaseInfo;

/**
 * Created by RonaldZboj on 2017-07-03.
 */

public class MainActivity extends AppCompatActivity {

    // Database helper for access to the database
    private HabitDbHelper mDbHelper = new HabitDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        HabitDbHelper.insertHabit(db);

        db = mDbHelper.getReadableDatabase();
        Cursor cursor = DisplayDatabaseInfo(db);

    }
}

