/*
 * Decompiled with CFR 0_58.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.util.Log
 *  java.lang.String
 */
package com.example.spinnersampleex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.lang.String;

public class DBHelper
extends SQLiteOpenHelper {
    public DBHelper(Context context, String string, SQLiteDatabase.CursorFactory cursorFactory, int n) {
        super(context, string, cursorFactory, n);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("Create Table oteller(HotelID INTEGER PRIMARY KEY, Adi Text, Tipi Text, Adres Text, Fiyat Number);");
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        Log.i((String)("Bilgi"), (String)("Baglanti acildi"));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase22, int sQLiteDatabase22, int sQLiteDatabase22) {
    }
}

