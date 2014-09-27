/*
 * Decompiled with CFR 0_58.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.util.Log
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.String
 */
package com.kpss.kpsstarih;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.String;

public class Veritabani
extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kpsstarih.db";
    private static final String DATABASE_PATH = "/data/data/com.kpss.kpsstarih/databases/";
    private static final int DATABASE_VERSION = 2;
    Context ctx;
    private SQLiteDatabase db;

    public Veritabani(Context context) {
        super(context, "kpsstarih.db", (SQLiteDatabase.CursorFactory)(null), 2);
        this.ctx = context;
    }

    public void CopyDataBaseFromAsset() throws IOException {
        InputStream inputStream = this.ctx.getAssets().open("kpsstarih.db");
        Log.e((String)("sample"), (String)("Starting copying"));
        File file = new File("/data/data/com.kpss.kpsstarih/databases");
        if (!(file.exists())) {
            file.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream("/data/data/com.kpss.kpsstarih/databases/kpsstarih.db");
        byte[] arrby = new byte[1024];
        do {
            int n;
            if ((n = inputStream.read(arrby)) <= 0) {
                Log.e((String)("sample"), (String)("Completed"));
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
                return;
            }
            fileOutputStream.write(arrby, 0, n);
        } while (true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase22, int sQLiteDatabase22, int sQLiteDatabase22) {
    }

    public void openDataBase() throws SQLException {
        this.db = SQLiteDatabase.openDatabase((String)("/data/data/com.kpss.kpsstarih/databases/kpsstarih.db"), (SQLiteDatabase.CursorFactory)(null), (int)(268435472));
    }
}

