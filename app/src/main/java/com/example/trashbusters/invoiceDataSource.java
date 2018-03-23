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

public class invoiceDataSource {

    private SQLiteDatabase invoiceDatabase;
    private invoiceDatabaseDriver dbHelper;

    public invoiceDataSource(Context context) {
        dbHelper = new invoiceDatabaseDriver(context);
    }

    public void open() throws SQLException {
        invoiceDatabase = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertInvoice(invoice u) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("NAME", u.getName());
            initialValues.put("ITEMINFO", u.getItemInfo());
            initialValues.put("PAY", u.getPay());
            initialValues.put("TIME", u.getTime());
            initialValues.put("STATUS", u.getStatus());

            didSucceed = invoiceDatabase.insert("INVOICE", null, initialValues) > 0;

        } catch (Exception e) {

        }
        return didSucceed;
    }

    public boolean updateInvoice(invoice u) {
        boolean didSucceed = false;
        try {
            Long rowId = (long) u.getId();
            ContentValues updateValues = new ContentValues();

            updateValues.put("NAME", u.getName());
            updateValues.put("ITEMINFO", u.getItemInfo());
            updateValues.put("PAY", u.getPay());
            updateValues.put("TIME", u.getTime());
            updateValues.put("STATUS", u.getStatus());

            didSucceed = invoiceDatabase.update("INVOICE", updateValues, "_id=" + rowId, null) > 0;
        }
        catch (Exception e) {
            //Do nothing -will return false if there is an exception
        }
        return didSucceed;
    }

    public int getLastInvoiceID() {
        int lastId = -1;
        try {
            String query = "Select MAX(_id) from INVOICE";
            Cursor cursor = invoiceDatabase.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        }
        catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }

    public ArrayList<String> getName() {
        ArrayList<String> invoiceNames = new ArrayList<String>();
        try {
            String query = "Select NAME from INVOICE";
            Cursor cursor = invoiceDatabase.rawQuery(query, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                invoiceNames.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }
        catch (Exception e) {
            invoiceNames = new ArrayList<String>();
        }
        return invoiceNames;
    }

    public ArrayList<invoice> getInvoice(String sortField, String sortOrder) {
        ArrayList<invoice> invoices = new ArrayList<invoice>();
        try {
            String query = "SELECT  * FROM INVOICE ORDER BY " + sortField + " " + sortOrder;

            Cursor cursor = invoiceDatabase.rawQuery(query, null);

            invoice newInvoice;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                newInvoice = new invoice();                                          //1
                newInvoice.setName(cursor.getString(0));
                newInvoice.setItemInfo(cursor.getString(1));
                newInvoice.setPay(cursor.getString(2));
                newInvoice.setTime(cursor.getString(3));
                newInvoice.setStatus(cursor.getString(4));

                invoices.add(newInvoice);
                cursor.moveToNext();
            }
            cursor.close();
        }
        catch (Exception e) {
            invoices = new ArrayList<invoice>();
        }
        return invoices;
    }

    public invoice getSpecificInvoice(int invoiceId) {
        invoice u = new invoice();
        String query = "SELECT  * FROM INVOICE WHERE _id =" + invoiceId;
        Cursor cursor = invoiceDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            u.setName(cursor.getString(0));
            u.setItemInfo(cursor.getString(1));
            u.setPay(cursor.getString(2));
            u.setTime(cursor.getString(3));
            u.setStatus(cursor.getString(4));

            cursor.close();
        }
        return u;
    }
}
