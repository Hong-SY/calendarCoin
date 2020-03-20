package com.example.hwProject.module;

import android.provider.BaseColumns;

public final class DataBases {

    public static final class CreateDB implements BaseColumns {
        public static String TITLE = "title";
        public static String DETAIL = "detail";
        public static String TO_DATE = "toDate";
        public static String FROM_DATE = "fromDate";
        public static String ALARM = "alarm";
        public static String PRIORITY = "priority";
        public static String START_HOUR = "startHour";
        public static String START_MIN = "startMin";
        public static String END_HOUR = "endHour";
        public static String END_MIN = "endMin";

        public static final String SCHEDULE_TABLE = "schedule";
        public static final String CREATE_SCHEDULE = "create table if not exists "+SCHEDULE_TABLE+"("
                +_ID+" integer primary key autoincrement, "
                +TITLE+" text not null , "
                +DETAIL+" text, "
                +TO_DATE+" text, "
                +FROM_DATE+" text, "
                +ALARM+" text, "
                +PRIORITY+" text, "
                +START_HOUR+" text, "
                +START_MIN+" text, "
                +END_HOUR+" text, "
                +END_MIN+" text);";
    }
}