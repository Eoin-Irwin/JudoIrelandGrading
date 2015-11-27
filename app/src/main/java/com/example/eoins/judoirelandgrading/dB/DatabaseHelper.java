package com.example.eoins.judoirelandgrading.dB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Encapsulate all information regarding
//the database and make it less complex
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Judo.db";
    public static final String TABLE_NAME = "Grading";
    public static final String COL_1 = "MEM_NO";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "GRADING_DATE";
    public static final String COL_4 = "GRADE";
    public static final String COL_5 = "SCORE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    //Create this table on create of the app
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (MEM_NO INTEGER PRIMARY KEY NOT NULL,NAME TEXT NOT NULL,GRADING_DATE DATE NOT NULL,GRADE TEXT NOT NULL, SCORE INTEGER NOT NULL)");
    }

    //Update the table to the current version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Inserting into the database from column 1-5
    //return the result that are not equal -1
    public boolean insertData(String mem_no, String name, String date, String grade, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues DBValues = new ContentValues();
        DBValues.put(COL_1, mem_no);
        DBValues.put(COL_2, name);
        DBValues.put(COL_3, date);
        DBValues.put(COL_4, grade);
        DBValues.put(COL_5, score);
        long result = db.insert(TABLE_NAME, null, DBValues);
        return result != -1;
    }

    //Delete data, use the mem_no
    //(Primary key) to reference the table
    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "MEM_NO = ?", new String[]{id});
    }

    //Select all of the data from the table
    //Return the result of this data
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

    //Update data, use the mem_no
    //(Primary key) to reference the table
    public boolean updateData(String mem_no, String name, String date, String grade, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues DBValues = new ContentValues();
        DBValues.put(COL_1, mem_no);
        DBValues.put(COL_2, name);
        DBValues.put(COL_3, date);
        DBValues.put(COL_4, grade);
        DBValues.put(COL_5, score);

        //Enter a valid mem_no so the database
        //knows which table is being updated
        db.update(TABLE_NAME, DBValues, "MEM_NO = ?", new String[]{mem_no});
        return true;
    }
}