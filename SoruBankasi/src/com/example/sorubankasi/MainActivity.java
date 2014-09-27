package com.example.sorubankasi;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
//import com.google.android.gms.ads.AdView;
import com.example.sorubankasi.Veritabani;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.CharSequence;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;

public class MainActivity
extends Activity
implements View.OnClickListener {
    private static final String AD_UNIT_ID = "ca-app-pub-2445017796951659/2838714755";
    //private AdView adView;
    String basilan = null;
    int basilan2;
    String dogrucevap = null;
    public long kac;
    private Veritabani vnesne;
    public String TextView;
    
    private void backsifirla() {
        TableRow tableRow = (TableRow)(this.findViewById(2131034123));
        TableRow tableRow2 = (TableRow)(this.findViewById(2131034125));
        TableRow tableRow3 = (TableRow)(this.findViewById(2131034127));
        TableRow tableRow4 = (TableRow)(this.findViewById(2131034129));
        TableRow tableRow5 = (TableRow)(this.findViewById(2131034131));
        tableRow.setBackgroundResource(2130837506);
        tableRow2.setBackgroundResource(2130837506);
        tableRow3.setBackgroundResource(2130837506);
        tableRow4.setBackgroundResource(2130837506);
        tableRow5.setBackgroundResource(2130837506);
    }

    private void istatistikgetir() {
        SQLiteDatabase sQLiteDatabase = this.vnesne.getReadableDatabase();
        Cursor cursor = sQLiteDatabase.rawQuery("select count(*) from sorular where dogruyanlis='dogru'", (String[])(null));
        cursor.moveToFirst();
        int n = cursor.getInt(0);
        Cursor cursor2 = sQLiteDatabase.rawQuery("select count(*) from sorular where dogruyanlis='yanlis'", (String[])(null));
        cursor2.moveToFirst();
        int n2 = cursor2.getInt(0);
        Cursor cursor3 = sQLiteDatabase.rawQuery("select count(*) from sorular where dogruyanlis='bos'", (String[])(null));
        cursor3.moveToFirst();
        int n3 = cursor3.getInt(0);
        (TextView)(this.findViewById(2131034138)).setText((CharSequence)((String.valueOf((Object)(String.valueOf((int)(n)))) + " do\u011fru " + String.valueOf((int)(n2)) + " yanl\u0131\u015f " + String.valueOf((int)(n3)) + " bo\u015f ")));
        cursor.close();
        cursor2.close();
    }

    private long kayitgetir() {
        String[] arrstring = new String[]{"id", "kac"};
        Cursor cursor = this.vnesne.getReadableDatabase().query("kacinci", arrstring, "id=1", (String[])(null), (String)(null), (String)(null), (String)(null));
        while (cursor.moveToNext()) {
            cursor.getLong(cursor.getColumnIndex("id"));
            this.kac = cursor.getLong(cursor.getColumnIndex("kac"));
            this.vnesne.close();
        }
        return this.kac;
    }

    private String kayitgetir2() {
        this.backsifirla();
        TextView textView = (TextView)(this.findViewById(2131034122));
        TextView textView2 = (TextView)(this.findViewById(2131034124));
        TextView textView3 = (TextView)(this.findViewById(2131034126));
        TextView textView4 = (TextView)(this.findViewById(2131034128));
        TextView textView5 = (TextView)(this.findViewById(2131034130));
        TextView textView6 = (TextView)(this.findViewById(2131034132));
        TextView textView7 = (TextView)(this.findViewById(2131034120));
        TableRow tableRow = (TableRow)(this.findViewById(2131034123));
        TableRow tableRow2 = (TableRow)(this.findViewById(2131034125));
        TableRow tableRow3 = (TableRow)(this.findViewById(2131034127));
        TableRow tableRow4 = (TableRow)(this.findViewById(2131034129));
        TableRow tableRow5 = (TableRow)(this.findViewById(2131034131));
        tableRow.setEnabled(true);
        tableRow2.setEnabled(true);
        tableRow3.setEnabled(true);
        tableRow4.setEnabled(true);
        tableRow5.setEnabled(true);
        this.kayitgetir();
        this.istatistikgetir();
        String[] arrstring = new String[]{"id", "soru", "cevapa", "cevapb", "cevapc", "cevapd", "cevape", "dogrucevap", "dogruyanlis"};
        Cursor cursor = this.vnesne.getReadableDatabase().query("sorular", arrstring, ("id=" + this.kac), (String[])(null), (String)(null), (String)(null), (String)(null));
        new StringBuilder();
        while (cursor.moveToNext()) {
            long l = cursor.getLong(cursor.getColumnIndex("id"));
            String string = cursor.getString(cursor.getColumnIndex("soru"));
            String string2 = cursor.getString(cursor.getColumnIndex("cevapa"));
            String string3 = cursor.getString(cursor.getColumnIndex("cevapb"));
            String string4 = cursor.getString(cursor.getColumnIndex("cevapc"));
            String string5 = cursor.getString(cursor.getColumnIndex("cevapd"));
            String string6 = cursor.getString(cursor.getColumnIndex("cevape"));
            String string7 = cursor.getString(cursor.getColumnIndex("dogruyanlis"));
            this.dogrucevap = cursor.getString(cursor.getColumnIndex("dogrucevap"));
            textView.setText((CharSequence)(("Soru " + String.valueOf((long)(l)) + " : " + string)));
            textView2.setText((CharSequence)(("A ) " + string2)));
            textView3.setText((CharSequence)(("B ) " + string3)));
            textView4.setText((CharSequence)(("C ) " + string4)));
            textView5.setText((CharSequence)(("D ) " + string5)));
            textView6.setText((CharSequence)(("E ) " + string6)));
            if (string7.equals((Object)("bos"))) {
                textView7.setTextColor(-16777216);
                textView7.setText((CharSequence)("Bu soruyu daha \u00f6nce yan\u0131tlamad\u0131n\u0131z."));
            }
            if (string7.equals((Object)("dogru"))) {
                textView7.setTextColor(-16711936);
                textView7.setText((CharSequence)("Bu soruyu daha \u00f6nce do\u011fru yan\u0131tlad\u0131n\u0131z."));
            }
            if (string7.equals((Object)("yanlis"))) {
                textView7.setTextColor(-65536);
                textView7.setText((CharSequence)("Bu soruyu daha \u00f6nce yanl\u0131\u015f yan\u0131tlad\u0131n\u0131z."));
            }
            this.vnesne.close();
        }
        return this.dogrucevap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     */
    public void kayitguncelle(long l, String string) {
        long l2 = (string.equals((Object)("arti"))) ? ((l + 1)) : ((l - 1));
        ContentValues contentValues = new ContentValues();
        contentValues.put("kac", Long.valueOf((long)(l2)));
        this.vnesne.getWritableDatabase().update("kacinci", contentValues, "id=1", (String[])(null));
        this.vnesne.close();
    }

    /*
     * Exception decompiling
     */
    public void onClick(View var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.getFarthestReachableInRange(Op03SimpleStatement.java:3105)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.examineSwitchContiguity(Op03SimpleStatement.java:4769)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.replaceRawSwitches(Op03SimpleStatement.java:4887)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:295)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:111)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:78)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:359)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:645)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:578)
        // org.benf.cfr.reader.Main.doJar(Main.java:108)
        // com.njlabs.showjava.AppProcessActivity$4.run(AppProcessActivity.java:412)
        // java.lang.Thread.run(Thread.java:856)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903040);
        this.vnesne = new Veritabani((Context)(this));
        try {
            if (!(new File(("/data/data/" + this.getPackageName() + "/databases/kpsstarih.db")).exists())) {
                new Veritabani((Context)(this));
                new Veritabani((Context)(this)).CopyDataBaseFromAsset();
            }
        }
        catch (FileNotFoundException var3_2) {
            var3_2.printStackTrace();
        }
        catch (IOException var2_3) {
            var2_3.printStackTrace();
        }
        (Button)(this.findViewById(2131034118)).setOnClickListener((View.OnClickListener)(this));
        (Button)(this.findViewById(2131034119)).setOnClickListener((View.OnClickListener)(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(2131361792, menu);
        return true;
    }
}

