package com.example.expandlayout;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    private final String[] array = {"Hello", "World", "Android", "is", "Awesome", "World", "Android", "is", "Awesome", "World", "Android", "is", "Awesome", "World", "Android", "is", "Awesome"};

    private ExpandableLayoutListView expandableLayoutListView = null; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.view_row, R.id.header_text, array);
        expandableLayoutListView = (ExpandableLayoutListView) findViewById(R.id.listview);

        initListViewData();
      //  expandableLayoutListView.setAdapter(arrayAdapter);
    }

    private void initListViewData() {
    	ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
    	
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("fileName", "testone");
    	map.put("fileDate", "2015/12/28");
    	map.put("fileDurantion", "10:00");
    	data.add(map);
    	
    	HashMap<String, Object> map2 = new HashMap<String, Object>();
    	map2.put("fileName", "testtwo");
    	map2.put("fileDate", "2015/12/29");
    	map2.put("fileDurantion", "10:01");
    	data.add(map2);
    	
    	HashMap<String, Object> map3 = new HashMap<String, Object>();
    	map3.put("fileName", "testThree");
    	map3.put("fileDate", "2015/12/30");
    	map3.put("fileDurantion", "10:02");
    	data.add(map3);
    	
    	ExpandableLayoutAdapter myAdapter = new ExpandableLayoutAdapter(this.getApplicationContext(), data);
    	
    	expandableLayoutListView.setAdapter(myAdapter);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }
}
