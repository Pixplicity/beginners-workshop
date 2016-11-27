package com.pixplicity.workshop.beginners.listviews;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewInLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Exercise 4.1
        setContentView(R.layout.activity_listview_in_layout);
        ListView listView = (ListView) findViewById(R.id.listview);
        String[] entries = getResources().getStringArray(R.array.animals);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                entries);
        listView.setAdapter(adapter);
    }

}