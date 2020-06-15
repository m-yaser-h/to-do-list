package com.example.todolist;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TaskViewHolder tvh = (TaskViewHolder)holder;
        tvh.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private class TaskViewHolder extends RecyclerView.ViewHolder{
        TextView TaskText;
        Switch is_done;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            TaskText = itemView.findViewById(R.id.textView2);
            is_done = itemView.findViewById(R.id.switch1);

        }

        void bind(Task task){
            TaskText.setText(task.getTitle());
            is_done.setChecked(task.is_done);

        }


    }


}
