package com.example.android.realmpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import io.realm.Realm;

public class DisplaySaved extends AppCompatActivity {

    Realm realm;
    ListView names;
    NameListAdapter nameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_saved);


        nameAdapter = new NameListAdapter(this);
//        nameAdapter.setData();
        realm = Realm.getDefaultInstance();
        names = (ListView) findViewById(R.id.names);
    }
}
