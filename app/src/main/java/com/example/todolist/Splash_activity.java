package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash_activity extends AppCompatActivity {
    private static int Splash_time = 4000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home_intent = new Intent(Splash_activity.this, MainActivity.class);
                startActivity(home_intent);
                finish();
            }
        }, Splash_time);
    }
}
