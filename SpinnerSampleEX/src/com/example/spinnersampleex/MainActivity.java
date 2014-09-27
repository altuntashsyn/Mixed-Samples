package com.example.spinnersampleex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.example.spinnersampleex.DBHelper;
import com.example.spinnersampleex.selam;
import java.lang.CharSequence;
import java.lang.Class;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;

public class MainActivity
extends Activity {
    private String[] sehirler;
    private Spinner spnSehirler;

    private void init() {
        this.spnSehirler = (Spinner)(this.findViewById(2131165186));
        this.sehirler = new String[5];
        this.sehirler[0] = "Roma";
        this.sehirler[1] = "Manchester";
        this.sehirler[2] = "Londra";
        this.sehirler[3] = "Paris";
        this.sehirler[4] = "Prag";
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context)(this), 2130903042, 2131165193, this.sehirler);
        this.spnSehirler.setAdapter((SpinnerAdapter)(arrayAdapter));
    }

    public void btnSec_Click(View view) {
        this.startActivity(new Intent((Context)(this), (Class)(selam.class)));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     */
    protected void onCreate(Bundle var1_1) {
        super.onCreate(var1_1);
        this.setContentView(2130903040);
        DBHelper dbh = new DBHelper((Context)(this), "Otel.db", null, 1);
        dbh.getReadableDatabase();
        dbh.execSQL("insert into oteller (Adi, Tipi, Adres, Fiyat) values ('aykut', 'tasdelen', 'Ankara', 15)");
        var3_3 = var2_2.query("oteller", new String[]{"Adi", "Adres", "Fiyat"}, "", (String[])(null), "", "", "Tipi DESC");
        var4_4 = "";
        block0 : while (var3_3.moveToNext()) {
            var5_5 = var3_3.getColumnNames();
            var6_6 = var5_5.length;
            var7_7 = 0;
            do {
                ** if (var7_7 >= var6_6) goto lbl17
lbl13: // 1 sources:
                var8_8 = var5_5[var7_7];
                var4_4 = (String.valueOf((Object)(var4_4)) + String.format((String)("%10s"), (Object[])(new Object[]{var8_8})));
                ++var7_7;
            } while (true);
lbl17: // 1 sources:
            var9_9 = (String.valueOf((Object)(var4_4)) + "\n\r");
            var10_10 = 0;
            do {
                if (var10_10 > (-1 + var3_3.getColumnCount())) {
                    var4_4 = (String.valueOf((Object)(var9_9)) + "..s\n\r");
                    continue block0;
                }
                var11_11 = new StringBuilder(String.valueOf((Object)(var9_9)));
                var12_12 = new Object[]{var3_3.getString(var10_10)};
                var9_9 = var11_11.append(String.format((String)("%10s"), (Object[])(var12_12))).toString();
                ++var10_10;
            } while (true);
        }
        (TextView)(this.findViewById(2131165187)).setText((CharSequence)(var4_4));
        this.init();
        var2_2.close();
    }
}
