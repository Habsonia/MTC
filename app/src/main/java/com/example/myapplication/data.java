package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class data extends SQLiteOpenHelper {

    private static final String DB_NAME = "Donnees.db";
    public data(Context context){
        super(context, DB_NAME, null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
