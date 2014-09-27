package com.altuntas.tarihsorubankasi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;



	public class Launcher extends Activity {
		
		public TextView Start;
		
		public void init()
		{
			Start = (TextView) findViewById(R.id.btnLauncher);
		}
		
		
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.launcher);
		init();
		
		Start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent listeleme = new Intent(getApplicationContext(), MainActivity.class);
				listeleme.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				getApplicationContext().startActivity(listeleme);	

				
				
			}
		});
		
			
		}
		
		

	}
	

