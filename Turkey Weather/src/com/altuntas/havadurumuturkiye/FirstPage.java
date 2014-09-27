package com.altuntas.havadurumuturkiye;

import java.util.ArrayList;

import com.altuntas.havadurumuturkiye.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

public class FirstPage extends Activity {

	
	private AutoCompleteTextView AutoView;
	public static String citym;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.first);
		    init();
		}
	 
	 
	private void init ()

	{
		
	    AutoView = (AutoCompleteTextView) findViewById(R.id.ListView);
		
		String[] iller={ "Adana, TR", "Adiyaman, TR", "Afyonkarahisar, TR", "Agri, TR",
	            "Amasya, TR", "Ankara, TR", "Antalya, TR", "Artvin, TR", "Aydin, TR", "Balikesir, TR",
	            "Bilecik, TR", "Bingol, TR", "Bitlis, TR", "Bolu, TR", "Burdur, TR", "Bursa, TR",
	            "Canakkale, TR", "Cankiri, TR", "Corum, TR", "Denizli, TR", "Diyarbakir, TR",
	            "Edirne, TR", "Elazig, TR", "Erzincan, TR", "Erzurum, TR", "Eskisehir, TR",
	            "Gaziantep, TR", "Giresun, TR", "Gumushane, TR", "Hakkari, TR", "Hatay, TR",
	            "Isparta, TR", "Mersin, TR", "Istanbul, TR", "Izmir, TR", "Kars, TR", "Kastamonu, TR",
	            "Kayseri, TR", "Kirklareli, TR", "Kirsehir, TR", "Kocaeli, TR", "Konya, TR",
	            "Kutahya, TR", "Malatya, TR", "Manisa, TR", "Kahramanmaras, TR", "Mardin, TR",
	            "Mugla, TR", "Mus, TR", "Nevsehir, TR", "Nigde, TR", "Ordu, TR", "Rize, TR", "Sakarya, TR",
	            "Samsun, TR", "Siirt, TR", "Sinop, TR", "Sivas, TR", "Tekirdag, TR", "Tokat, TR",
	            "Trabzon, TR", "Tunceli, TR", "Sanliurfa, TR", "Usak, TR", "Van, TR", "Yozgat, TR",
	            "Zonguldak, TR", "Aksaray, TR", "Bayburt, TR", "Karaman, TR", "Kirikkale, TR",
	            "Batman, TR", "Sirnak, TR", "Bartin, TR", "Ardahan, TR", "Igdir, TR", "Yalova, TR",
	            "Karabuk, TR", "Kilis, TR", "Osmaniye, TR", "Duzce, TR" };
		
		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < iller.length; i++)
		{
			list.add(iller[i]);		
		}
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		AutoView.setAdapter(adapter);
		AutoView.setOnItemClickListener(new AdapterView.OnItemClickListener(){ 

		
		public void onItemClick(AdapterView<?> parent, final View view,
	            int position, long id) {
	        final String item = (String) parent.getItemAtPosition(position);
	        
	    try{
	        //Bundle oluﬂturduk
	        Bundle extras = new Bundle();
	        extras.putString(citym, item);
	        //Intent oluﬂturduk
	        Intent intent = new Intent();
	        //Bundle'› intente ekledik
	        intent.putExtras(extras);
	        /**Yeni sayfa ça€›rma*/
	        
		
	        
	        intent.setClass(getApplicationContext(), MainActivity.class);
	        startActivity(intent);
		} catch (Exception e) {
		      e.printStackTrace();
		    }
	        
	       // Toast.makeText(getApplicationContext(), item, Toast.LENGTH_LONG).show();;
	        
		}
});
}	
}