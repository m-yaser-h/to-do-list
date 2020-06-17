package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskListadapter extends RecyclerView.Adapter {
    private List<Task> list;

    public TaskListadapter(List<Task> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        TaskViewHolder tvh = (TaskViewHolder)holder;
        tvh.bind(list.get(position));
        tvh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Detail_Of_Task.class);
                intent.putExtra("position",position);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private class TaskViewHolder extends RecyclerView.ViewHolder{
        TextView TaskText;
        Switch is_done;
        Context context;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            TaskText = itemView.findViewById(R.id.textView2);
            is_done = itemView.findViewById(R.id.switch1);
            context = itemView.getContext();

        }


        void bind(final Task task){
            TaskText.setText(task.getTitle());
            is_done.setChecked(task.isIs_done());



            is_done.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                        task.is_done=true;
                    else
                        task.is_done=false;
                }
            });


//            TaskText.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Intent intent = new Intent(context , Detail_Of_Task.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("title",task.getTitle());
//                    bundle.putString("description",task.getDescription());
//                    bundle.putString("date",task.getDate());
//                    bundle.putBoolean("is_done",task.isIs_done());
//                    intent.putExtras(bundle);
//                    context .startActivity(intent);
//
//
//                }
//            });



        }


    }


}
