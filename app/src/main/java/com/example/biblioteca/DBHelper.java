package com.example.biblioteca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLInput;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context,"Login.db", null,  1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create table libros(idlib TEXT primary key, nombrelib TEXT, edilib TEXT, paginaslib TEXT, descriplib TEXT)");
    }


    @Override
        public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists libros");
    }
    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result= MyDB.insert("users", null,contentValues);
        if(result==1) return false;
        else
            return true;

    }
    public Boolean insertData(String idlib, String nombrelib, String edilib, String paginaslib,String descriplib){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("idlib", idlib);
        contentValues.put("nombrelib", nombrelib);
        contentValues.put("edilib", edilib);
        contentValues.put("paginaslib",paginaslib);
        contentValues.put("descriplib", descriplib);
        long result= MyDB.insert("libros", null,contentValues);
        if(result==1) return false;
        else
            return true;

    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username= ?",new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username,password} );
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepasswordre(String userres, String passres){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{userres,passres} );
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public void consulta(String idlib, String nombrelib, String edilib, String paginaslib,String descriplib){
    SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from libros", new String[]{idlib,nombrelib,edilib,paginaslib,descriplib});
    }
}


