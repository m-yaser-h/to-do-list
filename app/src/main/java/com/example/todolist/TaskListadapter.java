package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

public class TaskListadapter extends RecyclerView.Adapter {
    private List<Task> list;

    public TaskListadapter(List<Task> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        TaskViewHolder tvh = (TaskViewHolder) holder;
        tvh.bind(list.get(position));
        tvh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Detail_Of_Task.class);
                intent.putExtra("position", position);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView TaskText;
        Switch is_done;
        Context context;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            TaskText = itemView.findViewById(R.id.textView2);
            is_done = itemView.findViewById(R.id.switch1);
            context = itemView.getContext();

        }


        void bind(final Task task) {
            TaskText.setText(task.getTitle());
            is_done.setChecked(task.isIs_done());

            boolean failed = false;
            String[] dates = task.getDate().split("/");
            int day = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int year = Integer.parseInt(dates[2]);
//            Log.i("day",dates[0]);
//            Log.i("month",dates[1]);
//            Log.i("year",dates[2]);



            Calendar cal = Calendar.getInstance();
            int current_year = cal.get(Calendar.YEAR);
            int current_month = cal.get(Calendar.MONTH);
            current_month+=1;
            int current_day = cal.get(Calendar.DAY_OF_MONTH);

//            Log.i("current_day",Integer.toString(current_day));
//            Log.i("current_month",Integer.toString(current_month));
//            Log.i("current_year",Integer.toString(current_year));


            if ((year < current_year) || (year== current_year && month<current_month) || (year== current_year && month==current_month && day<current_day)){
                failed=true;
            }

            if (failed){
                TaskText.setBackground(context.getResources().getDrawable(R.drawable.failed_task));
            }


            final boolean finalFailed = failed;
            is_done.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        task.setIs_done(true);
                        TaskText.setBackground(context.getResources().getDrawable(R.drawable.is_done_task));
                    }else if(!finalFailed) {
                        task.setIs_done(false);
                        TaskText.setBackground(context.getResources().getDrawable(R.drawable.background_for_each_task));
                    }else {
                        task.setIs_done(false);
                        TaskText.setBackground(context.getResources().getDrawable(R.drawable.failed_task));
                    }
                }
            });
        }
    }
}
