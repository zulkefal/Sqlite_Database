package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class Listview extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    database data;
    Cursor cursor;
    listadapter adapter;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        adapter=new listadapter(getApplicationContext(),R.layout.row);
        listview= (ListView) findViewById(R.id.list);
        data= new database (getApplicationContext());
        sqLiteDatabase=data.getReadableDatabase();
        cursor=data.getAllData();
        listview.setAdapter(adapter);
        if(cursor.moveToFirst())
        {
            do {
                String id,name,father,semes, sec,mark, pho;
                id=cursor.getString(0);
                name=cursor.getString(1);
                father=cursor.getString(2);
                semes=cursor.getString(3);
                sec=cursor.getString(4);
                mark=cursor.getString(5);
                pho=cursor.getString(6);

                dataprovider datap=new dataprovider(id,name,father,semes,sec,mark,pho);
                adapter.add(datap);


                }while(cursor.moveToNext());
        }
    }
}