package com.example.hwProject.module;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper {

    private static final String DATABASE_NAME = "calender.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    private class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(DataBases.CreateDB.CREATE_SCHEDULE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS "+DataBases.CreateDB.SCHEDULE_TABLE);
            onCreate(db);
        }
    }

    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

    public DbOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void create(){
        mDBHelper.onCreate(mDB);
    }

    public void close(){
        mDB.close();
    }

    public Cursor selectColumns(){
        return mDB.query(DataBases.CreateDB.SCHEDULE_TABLE, null, null, null, null, null, null);
    }

    public long insertColumn(String title, String detail, String toDate, String fromDate, String alarm, String priority, String startHour, String startMin, String endHour, String endMin){
        ContentValues values = new ContentValues();
        values.put(DataBases.CreateDB.TITLE, title);
        values.put(DataBases.CreateDB.DETAIL, detail);
        values.put(DataBases.CreateDB.TO_DATE, toDate);
        values.put(DataBases.CreateDB.FROM_DATE, fromDate);
        values.put(DataBases.CreateDB.ALARM, alarm);
        values.put(DataBases.CreateDB.PRIORITY, priority);
        values.put(DataBases.CreateDB.START_HOUR, startHour);
        values.put(DataBases.CreateDB.START_MIN, startMin);
        values.put(DataBases.CreateDB.END_HOUR, endHour);
        values.put(DataBases.CreateDB.END_MIN, endMin);
        return mDB.insert(DataBases.CreateDB.SCHEDULE_TABLE, null, values);
    }

    public boolean updateColumn(String title, String detail, String toDate, String fromDate, String alarm, String priority, String startHour, String startMin, String endHour, String endMin){
        ContentValues values = new ContentValues();
        values.put(DataBases.CreateDB.TITLE, title);
        values.put(DataBases.CreateDB.DETAIL, detail);
        values.put(DataBases.CreateDB.TO_DATE, toDate);
        values.put(DataBases.CreateDB.FROM_DATE, fromDate);
        values.put(DataBases.CreateDB.ALARM, alarm);
        values.put(DataBases.CreateDB.PRIORITY, priority);
        values.put(DataBases.CreateDB.START_HOUR, startHour);
        values.put(DataBases.CreateDB.START_MIN, startMin);
        values.put(DataBases.CreateDB.END_HOUR, endHour);
        values.put(DataBases.CreateDB.END_MIN, endMin);
        return mDB.update(DataBases.CreateDB.SCHEDULE_TABLE, values, "title=" + title, null) > 0;
    }

    // Delete All
    public void deleteAllColumns() {
        mDB.delete(DataBases.CreateDB.SCHEDULE_TABLE, null, null);
    }

    // Delete Column
    public boolean deleteColumn(long id){
        return mDB.delete(DataBases.CreateDB.SCHEDULE_TABLE, "_id="+id, null) > 0;
    }

    // sort by column
    public Cursor sortColumn(String sort){
        Cursor c = mDB.rawQuery( "SELECT * FROM schedule ORDER BY " + sort + ";", null);
        return c;
    }
}
