package com.example.todolist;

import java.util.Date;

public class Task {
    private String title;
    private String description;
    private String date;
    private boolean is_done;
    private boolean is_failed;

    public Task(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
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

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

    public boolean isIs_failed() {
        return is_failed;
    }

    public void setIs_failed(boolean is_failed) {
        this.is_failed = is_failed;
    }
}

