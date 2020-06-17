package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    static List<Task> list = new ArrayList<>();
   static TaskListadapter adapter;
    int num = 0 ;


   public void firt_add_to_list(List<Task> list ){
       Task[] items={
               new Task("aaaa"),
               new Task("bbbb")
//                new Task("cccc"),
//                new Task("dddd"),
//                new Task("eeee"),
//                new Task("ffff"),
//                new Task("gggg"),
//                new Task("hhhh"),
//                new Task("iiii"),

       };

       list.addAll(Arrays.asList(items));

   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (num==0){
            firt_add_to_list(list);
            num++;
        }







        final Intent intent = new Intent(this, Add_page_activity.class);
        Button button = this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });



        RecyclerView recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TaskListadapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }
}
