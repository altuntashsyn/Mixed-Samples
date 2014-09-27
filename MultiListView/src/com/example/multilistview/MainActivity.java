package com.example.multilistview;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView list = (ListView) findViewById(R.id.schedule);
		
		
		
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("train", "101");
		map.put("from", "6:30 AM");
		map.put("to", "7:40 AM");
		mylist.add(map);
		
		map = new HashMap();
		map.put("train", "202");
		map.put("from", "7:30 AM");
		map.put("to", "8:40 PM");
		mylist.add(map);
		
		map = new HashMap();
		map.put("train", "303");
		map.put("from", "7:30 AM");
		map.put("to", "8:40 PM");
		mylist.add(map);

		SimpleAdapter arrayAdaptor = new SimpleAdapter(this, mylist, R.layout.row,
		            new String[] {"train", "from", "to"}, new int[] {R.id.TRAIN_CELL, R.id.FROM_CELL, R.id.TO_CELL});
		list.setAdapter(arrayAdaptor);
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
