package com.horizontalscrollviewwithpageindicator;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	public Button Btn;
	
	public void init()
	{
		Btn = (Button) findViewById(R.id.BtnView);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rela);
		init();

		
		Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent listeleme = new Intent(getApplicationContext(), PageIndicatorActivity.class);
				listeleme.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				getApplicationContext().startActivity(listeleme);
			}
		});
	}
}