package com.example.taskmaster;

public class Tasks {


    String title;
    String body;
    String state;


    public Tasks(String title, String body, String state) {
        this.title = title;
        this.body = body;
        this.state = state;
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




}
