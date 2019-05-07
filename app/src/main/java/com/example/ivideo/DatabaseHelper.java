package com.example.ivideo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table user (email text primary key , password text)");
        db.execSQL("create table movie (vid text primary key , vname text, num text, price text)");
        db.execSQL("create table cart (mname text primary key , spinner1 text, mprice text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists user ");
    }

    public  boolean insert(String email, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password",password);

        long ins=db.insert("user" ,null,contentValues);

        if(ins == -1) return false;
        else return  true;

    }

    //checking if email exists

    public  boolean chkEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=?" , new String [] {email});

        if(cursor.getCount()>0) return  false;
        else return  true;
    }

    //checking signin values

    public  boolean chkEmailPassword(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?" , new String[] {email,password});

        if(cursor.getCount()>0) return  false;
        else return  true;
    }

    public  boolean addMovie(String vid, String vname, String num, String price){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("vid", vid);
        contentValues.put("vname", vname);
        contentValues.put("num", num);
        contentValues.put("price", price);

        long add= db.insert("movie",null,contentValues);

        if(add==-1)return false;
        else return true;
    }

    //checking id movie id exists

    public boolean chkVid(String vid){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from movie where vid=?" , new String [] {vid});

        if(cursor.getCount()>0) return  false;
        else return  true;
    }

    //Insert to cart
    public  boolean addCart(String mname, String spinner1, String mprice){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mname", mname);
        contentValues.put("spinner1", spinner1);
        contentValues.put("mprice", mprice);

        long add= db.insert("cart",null,contentValues);

        if(add==-1)return false;
        else return true;
    }

    /*
    public  Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result =db.rawQuery("select * from movie",null);
        return  result;
    }
    */
}
