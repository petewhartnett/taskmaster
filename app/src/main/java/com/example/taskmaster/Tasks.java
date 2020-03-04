package com.example.taskmaster;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tasks {


    @PrimaryKey(autoGenerate = true)
     public long id;

    String title;
    String body;
    String state;
    String city;


    public Tasks(String title, String body, String state, String city) {
        this.title = title;
        this.body = body;
        this.state = state;
        this.city = city;
    }




    public String getTitle() {
        return title;
    }

    public String getState() {
        return state;
    }

    public String getBody() {
        return body;
    }

    public String getCity() {
        return city;
    }



}
