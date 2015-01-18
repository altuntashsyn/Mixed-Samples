package com.altunts.ingilizcekelime;

import com.altunts.ingilizcekelime.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	public TextView Text;
	public Button Start;
   
    
	public void init() {
		Start = (Button) findViewById(R.id.button1);
		Text = (TextView) findViewById(R.id.textView1);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		setTitle(" YDS KPDS Kelime Rehberi");
		//getActionBar().setIcon(R.drawable.icon);


		Start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent listeleme = new Intent(getApplicationContext(),
						Harf.class);
				listeleme.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				getApplicationContext().startActivity(listeleme);

			}
		});

	}

}
