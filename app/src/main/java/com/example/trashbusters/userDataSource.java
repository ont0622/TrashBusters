package com.example.trashbusters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.*;

/**
 * Daniel Oh
 */

public class userDataSource {

    private SQLiteDatabase userDatabase;
    private userDatabaseDriver dbHelper;

    public userDataSource(Context context) {
        dbHelper = new userDatabaseDriver(context);
    }

    public void open() throws SQLException {
        userDatabase = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertUser(users u) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("USERNAME", u.getUserName());
            initialValues.put("PASSWORD", u.getPassword());
            initialValues.put("FIRSTNAME", u.getFirstName());
            initialValues.put("LASTNAME", u.getLastName());
            initialValues.put("EMAIL", u.getEmail());
            initialValues.put("PHONENUMBER", u.getPhoneNumber());
            initialValues.put("ADDRESS", u.getAddress());
            initialValues.put("CITY", u.getCity());
            initialValues.put("STATE", u.getCity());
            initialValues.put("ZIP", u.getZip());
            initialValues.put("DOB", u.getDob());
            initialValues.put("USERTYPE", u.getUserType());
            initialValues.put("LICNESENUMBER", u.getLicenseNumber());
            initialValues.put("PLATENUMBER", u.getPlateNumber());

            didSucceed = userDatabase.insert("USERS", null, initialValues) > 0;

        } catch (Exception e) {

        }
        return didSucceed;
    }

    public boolean updateUser(users u) {
        boolean didSucceed = false;
        try {
            Long rowId = (long) u.getUsersID();
            ContentValues updateValues = new ContentValues();

            updateValues.put("USERNAME", u.getUserName());
            updateValues.put("PASSWORD", u.getPassword());
            updateValues.put("FIRSTNAME", u.getFirstName());
            updateValues.put("LASTNAME", u.getLastName());
            updateValues.put("EMAIL", u.getEmail());
            updateValues.put("PHONENUMBER", u.getPhoneNumber());
            updateValues.put("ADDRESS", u.getAddress());
            updateValues.put("CITY", u.getCity());
            updateValues.put("STATE", u.getCity());
            updateValues.put("ZIP", u.getZip());
            updateValues.put("DOB", u.getDob());
            updateValues.put("USERTYPE", u.getUserType());
            updateValues.put("LICNESENUMBER", u.getLicenseNumber());
            updateValues.put("PLATENUMBER", u.getPlateNumber());

            didSucceed = userDatabase.update("users", updateValues, "_id=" + rowId, null) > 0;
        }
        catch (Exception e) {
            //Do nothing -will return false if there is an exception
        }
        return didSucceed;
    }

    public int getLastUsersID() {
        int lastId = -1;
        try {
            String query = "Select MAX(_id) from USERS";
            Cursor cursor = userDatabase.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        }
        catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }

    public ArrayList<String> getFirstName() {
        ArrayList<String> usersNames = new ArrayList<String>();
        try {
            String query = "Select FIRSTNAME from USERS";
            Cursor cursor = userDatabase.rawQuery(query, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                usersNames.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }
        catch (Exception e) {
            usersNames = new ArrayList<String>();
        }
        return usersNames;
    }

    public ArrayList<users> getUsers(String sortField, String sortOrder) {
        ArrayList<users> users = new ArrayList<users>();
        try {
            String query = "SELECT  * FROM USERS ORDER BY " + sortField + " " + sortOrder;

            Cursor cursor = userDatabase.rawQuery(query, null);

            users newUsers;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                newUsers = new users();

                newUsers.setUserName(cursor.getString(0));
                newUsers.setPassword(cursor.getString(1));
                newUsers.setFirstName(cursor.getString(2));
                newUsers.setLastName(cursor.getString(3));
                newUsers.setEmail(cursor.getString(4));
                newUsers.setPhoneNumber(cursor.getString(5));
                newUsers.setAddress(cursor.getString(6));
                newUsers.setCity(cursor.getString(7));
                newUsers.setState(cursor.getString(8));
                newUsers.setZip(cursor.getString(9));
                newUsers.setDob(cursor.getString(10));
                newUsers.setUserType(cursor.getInt(11));
                newUsers.setLicenseNumber(cursor.getString(12));
                newUsers.setPlateNumber(cursor.getString(13));

                users.add(newUsers);
                cursor.moveToNext();
            }
            cursor.close();
        }
        catch (Exception e) {
            users = new ArrayList<users>();
        }
        return users;
    }

    public users getSpecificUsers(int userId) {
        users u = new users();
        String query = "SELECT  * FROM USERS WHERE _id =" + userId;
        Cursor cursor = userDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            u.setUserName(cursor.getString(0));
            u.setPassword(cursor.getString(1));
            u.setFirstName(cursor.getString(2));
            u.setLastName(cursor.getString(3));
            u.setEmail(cursor.getString(4));
            u.setPhoneNumber(cursor.getString(5));
            u.setAddress(cursor.getString(6));
            u.setCity(cursor.getString(7));
            u.setState(cursor.getString(8));
            u.setZip(cursor.getString(9));
            u.setDob(cursor.getString(10));
            u.setUserType(cursor.getInt(11));
            u.setLicenseNumber(cursor.getString(12));
            u.setPlateNumber(cursor.getString(13));

            cursor.close();
        }
        return u;
    }
}


