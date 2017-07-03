package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by RonaldZboj on 2017-07-03.
 */

public class HabitContract {

    public static class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_HOW_MANY_TIMES = "how_many_times";
        public static final String COLUMN_HABIT_WHAT_TIME_PERIOD = "what_time_period";

        // Possible values for what_time_period
        public static final int WHAT_TIME_PERIOD_DAY = 0;
        public static final int WHAT_TIME_PERIOD_WEEK = 1;
        public static final int WHAT_TIME_PERIOD_MONTH = 2;
    }

}
