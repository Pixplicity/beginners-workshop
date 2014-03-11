package org.dutchaug.workshop.beginners.listviews;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class CustomAdapterActivity extends ListActivity {

    private CustomAdapter mCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCustomAdapter = new CustomAdapter(this);
        getListView().setAdapter(mCustomAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Animal animal = (Animal) mCustomAdapter.getItem(position);
        Uri uri = Uri.parse(animal.infoUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}