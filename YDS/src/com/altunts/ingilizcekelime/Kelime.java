package com.altunts.ingilizcekelime;

import java.io.IOException;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Kelime extends Activity {

	Cursor ca = null;
	public Button Geri;
	public TextView Text;
	public TextView Text2;
	public TextView Text3;
	public TextView Text4;
	public Button Ileri;
	
	 private InterstitialAd interstitial;

	    public void ad() {
	    	
	        // Prepare the Interstitial Ad
	        interstitial = new InterstitialAd(Kelime.this);
	        
	        // Insert the Ad Unit ID
	        interstitial.setAdUnitId("ca-app-pub-8663287796088108/1878200078");
	 
	        //Locate the Banner Ad in activity_main.xml
	        AdView adView = (AdView) this.findViewById(R.id.adView);
	 
	        // Request for Ads
	        AdRequest adRequest = new AdRequest.Builder()
	 
	        // Add a test device to show Test Ads
	         //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
	         //.addTestDevice("CC5F2C72DF2B356BBF0DA198")
	                .build();
	 
	        // Load ads into Banner Ads
	        adView.loadAd(adRequest);
	 
	        // Load ads into Interstitial Ads
	        interstitial.loadAd(adRequest);
	 
	        // Prepare an Interstitial Ad Listener
	        interstitial.setAdListener(new AdListener() {
	            public void onAdLoaded() {
	            	
	         // Call displayInterstitial() function
	                displayInterstitial();
	            }
	        });
	    }
	    public void displayInterstitial() {
	        // If Ads are loaded, show Interstitial else show nothing.
	        if (interstitial.isLoaded()) {
	            interstitial.show();
	        }
	    }

	public void init() {
		Geri = (Button) findViewById(R.id.button1);
		Text = (TextView) findViewById(R.id.textView2);
		Text2 = (TextView) findViewById(R.id.textView1);
		Text3 = (TextView) findViewById(R.id.textView3);
		Text4 = (TextView) findViewById(R.id.textView4);
		Ileri = (Button) findViewById(R.id.button2);
		Text4.setText(String.valueOf(1));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.soru);
		init();
		ad();
		setTitle(" YDS KPDS Kelime Rehberi");
		//getActionBar().setIcon(R.drawable.icon);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {

			String value = extras.getString("harf");
			Text3.setText(value);
		}

		Ileri.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Geri.setEnabled(true);

				int j = Integer.parseInt(Text4.getText().toString());

				j = j + 1;

				Text4.setText(String.valueOf(j));

				DatabaseHelper myDbHelper = new DatabaseHelper(
						getApplicationContext());

				try {

					myDbHelper.createDataBase();

				} catch (IOException ioe) {

					throw new Error("Unable to create database");

				}

				try {

					myDbHelper.openDataBase();

				} catch (SQLException sqle) {

					throw sqle;

				}
				Text.setText("");
				Text2.setText("");
				String value = (String) Text3.getText();
				ca = myDbHelper.querystring(value, j);
				if (ca.moveToFirst()) {
					do {
						String kelime = ca.getString(1);
						String anlami = ca.getString(2);
						Text.setText(kelime);
						Text2.setText(anlami);
					} while (ca.moveToNext());
				}
				if (Text.getText().length() < 1) {
					Ileri.setEnabled(false);
					Text.setText("Geri Butonu ile bir önceki kelimeye dönebilirsiniz");
				}

			}
		});

		DatabaseHelper myDbHelper = new DatabaseHelper(getApplicationContext());

		try {

			myDbHelper.createDataBase();

		} catch (IOException ioe) {

			throw new Error("Unable to create database");

		}

		try {

			myDbHelper.openDataBase();

		} catch (SQLException sqle) {

			throw sqle;

		}

		String value = (String) Text3.getText();
		ca = myDbHelper.querystr(value);
		if (ca.moveToFirst()) {
			do {
				String kelime = ca.getString(1);
				String anlami = ca.getString(2);
				Text.setText(kelime);
				Text2.setText(anlami);
			} while (ca.moveToNext());
		}

		Geri.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Ileri.setEnabled(true);

				int k = Integer.parseInt(Text4.getText().toString());

				if (k == 1) {
					Geri.setEnabled(false);
				}

				k = k - 1;

				Text4.setText(String.valueOf(k));

				DatabaseHelper myDbHelper = new DatabaseHelper(
						getApplicationContext());

				try {

					myDbHelper.createDataBase();

				} catch (IOException ioe) {

					throw new Error("Unable to create database");

				}

				try {

					myDbHelper.openDataBase();

				} catch (SQLException sqle) {

					throw sqle;

				}
				Text2.setText("");

				String value = (String) Text3.getText();
				ca = myDbHelper.querystring(value, k);
				if (ca.moveToFirst()) {
					do {
						String kelime = ca.getString(1);
						String anlami = ca.getString(2);
						Text.setText(kelime);
						Text2.setText(anlami);
					} while (ca.moveToNext());
				}

				/*
				 * Intent listeleme = new Intent(getApplicationContext(),
				 * MainActivity.class);
				 * listeleme.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				 * getApplicationContext().startActivity(listeleme);
				 */

			}
		});

	}

}
