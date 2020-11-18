package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Detail_Of_Task extends AppCompatActivity {
    TextView title_in_detail;
    TextView description_in_detail;
    TextView date_in_detail;
    Switch switch_in_detail;
    Intent intent;
    int position;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_task);
        intent = this.getIntent();
        title_in_detail = findViewById(R.id.textView3);
        description_in_detail = findViewById(R.id.textView4);
        date_in_detail = findViewById(R.id.textView5);
        switch_in_detail = findViewById(R.id.switch2);


        position = intent.getIntExtra("position", 0);


        title_in_detail.setText(MainActivity.list.get(position).getTitle());
        description_in_detail.setText(MainActivity.list.get(position).getDescription());
        switch_in_detail.setChecked(MainActivity.list.get(position).isIs_done());
        date_in_detail.setText(MainActivity.list.get(position).getDate());

        switch_in_detail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity.list.get(position).setIs_done(isChecked);
                MainActivity.adapter.notifyDataSetChanged();

            }
        });
    }
}
