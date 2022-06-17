package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class database extends SQLiteOpenHelper {
    public static final String Unidatabase = "class.db";
    public static final String TABLE = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Father";
    public static final String COL_4 = "Semester";
    public static final String COL_5 = "Section";
    public static final String COL_6 = "Marks";
    public static final String COL_7 = "Phone";

    public database(@Nullable Context context) {
        super(context, Unidatabase, null, 1);
        //  SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE + "(ID Text , Name Text , Father Text , Semester Text , Section Text , Marks Text , Phone Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public boolean insertdata(String id, String Name, String Father, String Semester, String Section, String marks, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(COL_1, id);
        value.put(COL_2, Name);
        value.put(COL_3, Father);
        value.put(COL_4, Semester);
        value.put(COL_5, Section);
        value.put(COL_6, marks);
        value.put(COL_7, phone);
        long result = db.insert(TABLE, null, value);
        if (result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor res=db.rawQuery("select * from "+ TABLE,null);
        String query = "select * from " + TABLE;
        Cursor cursor = db.rawQuery(query, null);
          return cursor;
    }



    public boolean update(String id,String Name,String Father, String Semester, String Section , String marks, String phone )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value= new ContentValues();
        value.put(COL_1,id);
        value.put(COL_2,Name);
        value.put(COL_3,Father);
        value.put(COL_4,Semester);
        value.put(COL_5,Section);
        value.put(COL_6,marks);
        value.put(COL_7,phone);
        db.update(TABLE,value,"ID = ? ",new String [] {id});
        db.close();
        return true;
    }

}
