package com.example.todolist;

import java.util.Date;

public class Task {
    String title;
    String description;
    String date;
    boolean is_done;

    public Task(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.is_done=false;
    }

    public Task(String title) {
        this.title = title;
        this.description ="";
        this.date = null;
        this.is_done=false;


    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

public String getDate() {
        return date;
    }

    public boolean isIs_done() {
        return is_done;
    }
}

