package com.example.trashbusters;

import android.content.Context;
import android.database.sqlite.*;
import android.util.Log;

/**
 * Created by Daniel Oh
 *
 * USERS id db will have 13 columns.
 * ID - PRIMARY KEY
 * FIRSTNAME
 * LASTNAME
 * EMAIL
 * PHONENUMBER
 * ADDRESS
 * CITY
 * STATE
 * ZIP
 * DOB - dob is in text format, so we can deal with /
 * USERTYPE - 1 for customer, 2 for driver
 * LICENSENUMBER - only for driver, it can be null
 * PLATENUMBER - only for driver, it can be null
 *
 *
 * -Notes
 *   This class does NOT contain any code related to sharedPreferences, thus if you decide to do
 *   something about it, you will have to create function on your own.
 *   In other word, this class will create functions only related to database.
 */

public class userDatabaseDriver extends SQLiteOpenHelper{

    private static final String USER_DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;

    //Initial Table Creation
    private static final String CREATE_TABLE_USER = "" +
            "CREATE TABLE USERS (_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "FIRSTNAME TEXT NOT NULL, " +
            "LASTNAME TEXT NOT NULL, " +
            "EMAIL TEXT NOT NULL, " +
            "PHONENUMBER TEXT NOT NULL, " +
            "ADDRESS TEXT NOT NULL, " +
            "CITY TEXT NOT NULL, " +
            "STATE TEXT NOT NULL, " +
            "ZIP TEXT NOT NULL, " +
            "DOB TEXT NOT NULL, " +
            "USERTYPE INTEGER NOT NULL, " +
            "LICENSENUMBER TEXT, " +
            "PLATENUMBER TEXT);";


    public userDatabaseDriver(Context context){
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
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(sqLiteDatabase);
    }
}
