package com.altuntas.havadurumuturkiye;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpJsonConnection {
	
	private static String Base_URL ="http://api.openweathermap.org/data/2.5/weather?q=";
	
	public String getHavaDurumu(String bolge)
	{
		HttpURLConnection baglanti = null;
		InputStream input =null;
		try {
			baglanti = (HttpURLConnection) (new URL(Base_URL + bolge)).openConnection();
			baglanti.setRequestMethod("GET");
			baglanti.connect();
		
			//Lets read Response
			
			StringBuffer sbuf = new StringBuffer();
			input = baglanti.getInputStream();
			BufferedReader bufr = new BufferedReader(new InputStreamReader(input));
			String line =  null;
			while ( (line = bufr.readLine()) != null )
				sbuf.append(line +"\r\n");
			
			input.close();
			baglanti.disconnect();
			return sbuf.toString();
			
	} catch(Throwable t)
	{
	t.printStackTrace();	
	}
		finally{
			
			try{input.close();} catch(Throwable t){}
			try{baglanti.disconnect();} catch(Throwable t){}

		}
	return null;
	}
}
