package com.example.loginapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Creating all the necessary variables
    private static final String Database_Name="UOG.db";
    private static final String Table_Name="student_table";
    private static final String Table_2="student_record";
    private static final String Col_1="Roll_No";
    private static final String Col_2="Email";
    private static final String Col_3="First_name";
    private static final String Col_4="Last_name";
    private static final String Col_5="Password";
    private static final String Col_6 ="Department_Name";
    private static final String Col_7 ="Language";
    private static final String Col_8 ="SDate";
    private static final String Col_9 ="Contact_No";
    private static final String Col_10="Registration_No";
    private static final String Col_11="Cnic_No";
    private static final String Col_12="Subject";
    private static final String Col_13 ="Hod_Remarks";

    //Create Database with name UOG
    public DatabaseHelper(@Nullable Context context) {

        super(context, Database_Name, null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    //Create Table of Student
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table "+Table_Name+"(Roll_No Text Primary Key,Email Text,First_name Text,Last_name Text,Password Text)");
        //Creating table of student record
        db.execSQL("create table "+Table_2+"(Roll_No Text,First_name Text,Last_name Text,Department_Name Text,Language Text,SDate Text,Contact_No Text,Registration_No Text,Cnic_No Text,Subject Text,Hod_Remarks Text)");
    }

    //Drop Table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if Exists "+Table_Name);
        db.execSQL("Drop Table if Exists "+Table_2);
        onCreate(db);
    }

    //Method to insert data in the database
    public boolean insertData(String Roll_no,String Email,String First_Name,String Last_Name,String Password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_1,Roll_no);
        contentValues.put(Col_2,Email);
        contentValues.put(Col_3,First_Name);
        contentValues.put(Col_4,Last_Name);
        contentValues.put(Col_5,Password);
        long result=db.insert(Table_Name,null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    //Function to insert Record in the table
    public boolean insertData(String Roll_no, String First_Name, String Father_Name, String Department, String Language,String date,String ContactNo,String Registration_No,String CnicNo,String Subject,String HodRemark ){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_1,Roll_no);
        contentValues.put(Col_3,First_Name);
        contentValues.put(Col_4,Father_Name);
        contentValues.put(Col_6,Department);
        contentValues.put(Col_7,Language);
        contentValues.put(Col_8,date);
        contentValues.put(Col_9,ContactNo);
        contentValues.put(Col_10,Registration_No);
        contentValues.put(Col_11,CnicNo);
        contentValues.put(Col_12,Subject);
        contentValues.put(Col_13,HodRemark);
        long result =db.insert(Table_2,null,contentValues);
        if(result ==-1){
            return false;
        }else{
            return false;
        }
    }
    //To check username if it's already exist in database
    public Boolean checkUserName(String roll_No){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from "+Table_Name+" where Roll_No =?",new String[]{roll_No});
        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    //To check username and password
    public Boolean checkusernamepassword(String rollNo,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from "+Table_Name+" where Roll_No=? and Password=?",new String[]{rollNo,password});
        if (cursor.getCount()>0){
            return true;}
        else{
            return false;
        }
    }

}
