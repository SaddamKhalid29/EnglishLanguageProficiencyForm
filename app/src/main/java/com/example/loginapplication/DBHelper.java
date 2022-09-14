package com.example.loginapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DatabaseName = " StudentsRecord.db";
    public static final String Table_Name = "StudentsRecordTable";
    public static final String Col_0 = "ID";
    public static final String Col_1 = "firstName";
    public static final String Col_2 = "lastName";
    public static final String Col_3 = "roll_No";
    public static final String Col_4 = "Email";
    public static final String Col_5 = "Department";
    public static final String Col_6 = "Language";
    public static final String Col_7 = "Date";
    public static final String Col_8 = "ContactNo";
    public static final String Col_9 = "RegistrationNo";
    public static final String Col_10 = "CNICNo";
    public static final String Col_11 = "Subject";
    public static final String Col_12 = "HodRemarks";

    public DBHelper(@Nullable Context context) {
        super(context, DatabaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " + Table_Name + "(ID Integer Primary Key Autoincrement,firstName Text,lastName Text,roll_No Text,Email Text,Department Text,Language Text,Date Text,ContactNo Text,RegistrationNo Text,CNICNo Text,Subject Text,HodRemarks Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if Exists " + Table_Name);
        onCreate(db);
    }

    //To insert the  record
    public boolean insert(String firtName, String lastName, String rollNo, String Email, String Department, String Language, String Date, String Contact, String Regist, String CNIC, String Subject, String HodRemarks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1, firtName);
        contentValues.put(Col_2, lastName);
        contentValues.put(Col_3, rollNo);
        contentValues.put(Col_4, Email);
        contentValues.put(Col_5, Department);
        contentValues.put(Col_6, Language);
        contentValues.put(Col_7, Date);
        contentValues.put(Col_8, Contact);
        contentValues.put(Col_9, Regist);
        contentValues.put(Col_10, CNIC);
        contentValues.put(Col_11, Subject);
        contentValues.put(Col_12, HodRemarks);
        long result = db.insert(Table_Name, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //To get the data
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + Table_Name, null);
        return res;
    }

    //To update the  record
    public boolean Update(String firtName, String lastName, String rollNo, String Email, String Department, String Language, String Date, String Contact, String Regist, String CNIC, String Subject, String HodRemarks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1, firtName);
        contentValues.put(Col_2, lastName);
        contentValues.put(Col_4, Email);
        contentValues.put(Col_5, Department);
        contentValues.put(Col_6, Language);
        contentValues.put(Col_7, Date);
        contentValues.put(Col_8, Contact);
        contentValues.put(Col_9, Regist);
        contentValues.put(Col_10, CNIC);
        contentValues.put(Col_11, Subject);
        contentValues.put(Col_12, HodRemarks);
        Cursor cursor = db.rawQuery("Select * from " + Table_Name + " where roll_No=?", new String[]{rollNo});
        if (cursor.getCount() > 0) {
            long result = db.update(Table_Name, contentValues, "roll_No=?", new String[]{rollNo});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    //To delete the data
    public boolean deleteData(String rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + Table_Name + " where roll_No=?", new String[]{rollNo});
        if (cursor.getCount() > 0) {
            long result = db.delete(Table_Name, " roll_No=?", new String[]{rollNo});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
