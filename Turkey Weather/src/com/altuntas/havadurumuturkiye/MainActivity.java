package com.altuntas.havadurumuturkiye;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;

import com.altuntas.havadurumuturkiye.R;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Telephony.Sms.Conversations;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ImageView imageAcik;
	private ImageView imageBulutlu;
	private ImageView imageSaganak;
	private ImageView imageSnow;
	private ListView schedule;
	private TextView cityText;
	private TextView havaDesc;
	private TextView temp;
	private Bundle extras= null;
	private String city;
	public String sonuc ="";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	
	private String weatherConverter(String description)
	{
		if(description.equals("Clear"))
		{
			sonuc="Aç›k";
		    imageAcik.setVisibility(1);
		}
		else if (description.equals("Clouds")) 
		{
			sonuc="Bulutlu";
			  imageBulutlu.setVisibility(1);
		}
		else if (description.equals("Thunderstorm")) 
		{
			sonuc="Sa€anak";
		    imageSaganak.setVisibility(1);

		}
		else if (description.equals("Snow")) 
		{
			sonuc="Karl›";
			imageSnow.setVisibility(1);
		}
		else if (description.equals("Rain")) 
		{
			sonuc="Ya€murlu";
			imageSaganak.setVisibility(1);
		}
		else 
		{
			sonuc="Di€er";
		}
		return sonuc;
	}

	private void init() {
		 imageAcik = (ImageView) findViewById(R.id.acik);
		 imageBulutlu = (ImageView) findViewById(R.id.bulutlu);
		 imageSaganak = (ImageView) findViewById(R.id.saganak);
		 imageSnow = (ImageView) findViewById(R.id.snow);
		cityText = (TextView) findViewById(R.id.cityText);
		havaDesc = (TextView) findViewById(R.id.havaDesc);
		temp = (TextView) findViewById(R.id.temp);
		 extras = getIntent().getExtras();
		 city = extras.getString(FirstPage.citym);
		JsonHavaTask task = new JsonHavaTask();
		task.execute(new String[] { city });
		
	}

	private class JsonHavaTask extends AsyncTask<String, Void, Hava>

	{

		@Override
		protected Hava doInBackground(String... params) {
			Hava hava = new Hava();
			String data = ((new HttpJsonConnection()).getHavaDurumu(params[0]));

			try {
				hava = HavaParser.getHava(data);
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return hava;
		}

		@Override
		protected void onPostExecute(Hava hava) {
			super.onPostExecute(hava);
			temp.setText("" + Math.round((hava.sicaklik.getTemp() - 273.15))+ "°");
			String weatherDesc = weatherConverter(hava.anlikhava.getDescription());
			havaDesc.setText(weatherDesc);
			// havaDesc.setText(String.valueOf(hava.bolge.getLatitude()));
			cityText.setText(hava.bolge.getCity());
		}

	}

}
