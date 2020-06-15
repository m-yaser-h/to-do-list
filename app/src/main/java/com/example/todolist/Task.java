package com.example.todolist;

import java.util.Date;

public class Task {
    String title;
    String description;
    Date date;
    boolean is_done;

    public Task(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.is_done=false;
    }

    public Task(String title) {
        this.title = title;
        this.description =null;
        this.date = null;
        this.is_done=false;


    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public boolean isIs_done() {
        return is_done;
    }
}

