package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Detail_Of_Task extends AppCompatActivity {
    TextView title_in_detail ;
    TextView description_in_detail ;
    TextView date_in_detail ;
    Switch switch_in_detail ;
    String input_title;
    String input_description;
    String input_date;
    Intent intent;
    boolean is_done;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_task);
        intent = this.getIntent();
         title_in_detail = findViewById(R.id.textView3);
         description_in_detail = findViewById(R.id.textView4);
         date_in_detail = findViewById(R.id.textView5);
         switch_in_detail = findViewById(R.id.switch2);
        Bundle bundle = intent.getExtras();
        input_title = bundle.getString("title");
        input_description = bundle.getString("description");
        input_date = bundle.getString("date");
        title_in_detail.setText(input_title);

        description_in_detail.setText(input_description);
        date_in_detail.setText(input_date);
        is_done = bundle.getBoolean("is_done");
        switch_in_detail.setChecked(is_done);
        switch_in_detail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    is_done=isChecked;
                    MainActivity.adapter.notifyDataSetChanged();

            }
        });


    }

}
