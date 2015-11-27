package com.example.eoins.judoirelandgrading.dB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (MEM_NO INTEGER PRIMARY KEY NOT NULL,NAME TEXT NOT NULL,GRADING_DATE DATE NOT NULL,GRADE TEXT NOT NULL, SCORE INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String mem_no,String name,String date,String grade,String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,mem_no);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3, date);
        contentValues.put(COL_4, grade);
        contentValues.put(COL_5, score);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"MEM_NO = ?",new String[] {id});
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String mem_no,String name,String date,String grade,String score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,mem_no);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,date);
        contentValues.put(COL_4, grade);
        contentValues.put(COL_5, score);


        db.update(TABLE_NAME,contentValues,"MEM_NO = ?",new String[] {mem_no});
        return true;

    }

}
