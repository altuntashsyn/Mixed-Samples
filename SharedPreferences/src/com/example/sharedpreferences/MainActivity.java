package com.example.sharedpreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public TextView TxtView1;
	public static final String PREFS_NAME="My Apps Settings";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TxtView1 = (TextView) findViewById(R.id.textView1);
		
		
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
		Editor editor = settings.edit();
		String a = "1";
		editor.putString(a, "Merhaba Merhaba");
		//editor.commit();
		String value = settings.getString("ilk", "");
		TxtView1.setText(value);
		Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
