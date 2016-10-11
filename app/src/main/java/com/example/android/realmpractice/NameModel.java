package com.example.android.realmpractice;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Skinner on 10/10/16.
 */

public class NameModel extends RealmObject {

    @PrimaryKey
    private String uid = UUID.randomUUID().toString();

    private String name = "Eugene";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

}
