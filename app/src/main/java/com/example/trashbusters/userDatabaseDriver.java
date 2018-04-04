package com.example.trashbusters;

import android.content.Context;
import android.database.sqlite.*;
import android.util.Log;

/**
 * Created by Daniel Oh
 *
 * USERS id db will have 15 columns.
 * ID - PRIMARY KEY
 * USERNAME
 * PASSWORD
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
            "USERNAME TEXT NOT NULL, " +
            "PASSWORD TEXT NOT NULL, " +
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



/*
public class userDatabaseDriver extends SQLiteOpenHelper {

    private static final String USER_DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;
    private static final String Table_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FNAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_LNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    private static final String COLUMN_PHONENUMBER = "phonenumber";
    private static final String COLUMN_ADRESS = "adress";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_ZIP = "zip";
    private static final String COLUMN_DOB = "dob";
    private static final String COLUMN_LICENSENUMBER = "licenseNumber";
    private static final String COLUMN_PLATENUMBER = "plateNumber";

    SQLiteDatabase db;


    //Initial Table Creation
    private static final String CREATE_TABLE_USER = "" +
            "CREATE TABLE USERS (_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "USERNAME TEXT NOT NULL, " +
            "PASSWORD TEXT NOT NULL, " +
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


    public userDatabaseDriver(Context context) {
        super(context, USER_DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
        this.db = db;
    }


    public void insertUser(users c) {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        String query = " select * from users ";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);

        values.put(COLUMN_FNAME, c.getFirstName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASS, c.getPassword());
        values.put(COLUMN_LNAME, c.getFirstName());
        values.put(COLUMN_ADRESS, c.getAddress());
        values.put(COLUMN_STATE, c.getState());
        values.put(COLUMN_DOB, c.getDob());
        values.put(COLUMN_PLATENUMBER, c.getPlateNumber());
        values.put(COLUMN_ZIP, c.getZip());
        values.put(COLUMN_LICENSENUMBER, c.getLicenseNumber());
        values.put(COLUMN_PHONENUMBER, c.getPhoneNumber());
        values.put(COLUMN_CITY, c.getCity());

        db.insert(Table_NAME, null, values);

    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // This WILL DROP THE TABLE, try not to play with it
        String query = "DROP TABLE IF EXISTS USERS"+ CREATE_TABLE_USER;
        db.execSQL(query);
        this.onCreate(db);
        Log.w(userDatabaseDriver.class.getName(), "Upgrading");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(sqLiteDatabase);
    }
}








*/
