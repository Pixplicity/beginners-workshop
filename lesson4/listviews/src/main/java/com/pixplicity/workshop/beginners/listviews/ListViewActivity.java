package com.pixplicity.workshop.beginners.listviews;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListViewActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Exercise 4.2
        String[] entries = getResources().getStringArray(R.array.animals);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                entries);
        getListView().setAdapter(adapter);
    }

}