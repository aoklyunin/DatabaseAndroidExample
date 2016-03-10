package com.example.aokly.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myDB";
    public static final String MY_TABLE = "myTable";
    public static final String KEY_STRING = "keyString";
    public static final String KEY_INTEGER = "keyInteger";
    public static final String KEY_ID = "keyID";

    // создание таблицы
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + MY_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_STRING + " INTEGER,"
                + KEY_INTEGER + " INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    // коструктор от контекста
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // обновление таблицы
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MY_TABLE);
        onCreate(db);
    }
    // добавляем аудиозапись
    public void addRec(String str, Integer i) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_STRING, str);
        values.put(KEY_INTEGER, i);
        db.insert(MY_TABLE, null, values);
        db.close();
    }
    // получаем список записей инта
    public List<Integer> getIntegerList() {
        List<Integer> lst = new ArrayList<Integer>();
        String selectQuery = "SELECT  * FROM " + MY_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                lst.add(cursor.getInt(2));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lst;
    }
    // получаем список записей инта
    public List<String> getStringList() {
        List<String> lst = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + MY_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                lst.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lst;
    }
    public void deleteAll() {
        // удаляем аудиозаписи
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MY_TABLE, null, null);
        db.close();
    }



}