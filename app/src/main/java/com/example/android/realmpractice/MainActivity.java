package com.example.android.realmpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    private Realm realm;

    EditText name;
    Button submit;
    Button segway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();

        realm = Realm.getDefaultInstance();

        name = (EditText) findViewById(R.id.name);
        submit = (Button) findViewById(R.id.submit);
        segway = (Button) findViewById(R.id.segway);
        segway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DisplaySaved.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.executeTransaction(new Realm.Transaction() {
                    String id = UUID.randomUUID().toString();

                    @Override
                    public void execute(Realm realm) {
                        NameModel newName = realm.createObject(NameModel.class, id);
                        Log.d("ID", "execute: " + newName.getUid());
                        newName.setName(name.getText().toString());
                        Log.d("NAME", "execute: " + newName.getName());
                    }

                });

                Log.d("whelp", realm.where(NameModel.class).findAll().toString());
            }
        });
     }
}
