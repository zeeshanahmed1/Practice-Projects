package com.example.developer.forh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "information.db";
    private static final String COL_ID = "id";
    private static final String TABLE_Name = "Name";
        private static final String COL_HABIT = "title";
    private static final String COL_DETAILS = "discription";



    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String sql = String.format("create table %s (%s INTEGER primary key AUTOINCREMENT,%s TEXT not null, %s TEXT )", TABLE_Name, COL_ID, COL_HABIT, COL_DETAILS);

        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveData(Habits arrayList) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_HABIT, arrayList.getHabit());
        values.put(COL_DETAILS, arrayList.getDetails());
        db.insert(TABLE_Name, null, values);
        db.close();
    }

    public List<Habits> getData() {
        List<Habits> arrayList = new ArrayList<Habits>();

        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("select %s,%s,%s from %s order by %s", COL_ID, COL_HABIT, COL_DETAILS, TABLE_Name, COL_ID);
        Cursor cursor = db.rawQuery(sql, null);


        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String msg = cursor.getString(2);
            arrayList.add(new Habits(title, msg, id));
        }
        db.close();
        return arrayList;
    }

    public void deleteItem(int pos) {
        this.getWritableDatabase().delete(TABLE_Name, COL_ID + "=" + pos, null);
    }

    public void updataeItem(int pos, String dis) {

        ContentValues cv = new ContentValues();

        cv.put(COL_DETAILS, dis);

        this.getWritableDatabase().update(TABLE_Name, cv, COL_ID + "=" + pos, null);
    }
}
