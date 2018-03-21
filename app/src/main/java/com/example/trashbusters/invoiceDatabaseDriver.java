package com.example.trashbusters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * CREATED BY DANIEL OH
 * invoice database will have 6 columns
 * ID - primary key
 * NAME - both first name last name. put them together
 * ITEMINFO - type of item such as trash, recycle and their weight. in text file.
 * PAY - also in text format.
 * STATUS - PENDING, ON PROCESS, FINISHED, ETC.
 */

public class invoiceDatabaseDriver extends SQLiteOpenHelper{

    private static final String USER_DATABASE_NAME = "invoice.db";
    private static final int DATABASE_VERSION = 1;

    //Initial Table Creation
    private static final String CREATE_TABLE_USER = "" +
            "CREATE TABLE INVOICE (_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NAME TEXT NOT NULL, " +
            "ITEMINFO TEXT NOT NULL, " +
            "PAY TEXT NOT NULL, " +
            "TIME TEXT NOT NULL, " +
            "STATUS TEXT NOT NULL);";


    public invoiceDatabaseDriver(Context context){
        super(context, USER_DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // This WILL DROP THE TABLE, try not to play with it
        Log.w(userDatabaseDriver.class.getName(), "Upgrading");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS invoice");
        onCreate(sqLiteDatabase);
    }
}
