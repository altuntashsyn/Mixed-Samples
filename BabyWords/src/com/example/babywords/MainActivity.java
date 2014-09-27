package com.example.babywords;
import android.view.View;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public TextView myTextView;
	public ImageView kopek;
	public ImageView cilek;

	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		myTextView = (TextView)findViewById(R.id.textview1);
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"allura/Allura-Regular.otf");
		myTextView.setTypeface(typeFace);
		myTextView.setTextColor(Color.BLUE);
		myTextView.setText("My Baby");
		kopek = (ImageView) findViewById(R.id.imageView2);
		cilek = (ImageView) findViewById(R.id.imageView1);

		
		kopek.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		    	Toast.makeText(getApplicationContext(), "K�pek", Toast.LENGTH_LONG).show();
				
			}
		});

		
		cilek.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		    	Toast.makeText(getApplicationContext(), "Cilek", Toast.LENGTH_LONG).show();
				
			}
		});

		
		
	}

	

	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}