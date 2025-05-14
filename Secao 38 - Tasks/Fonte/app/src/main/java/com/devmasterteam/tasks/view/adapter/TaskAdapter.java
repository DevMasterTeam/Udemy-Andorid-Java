package com.devmasterteam.tasks.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.databinding.ItemTaskBinding;
import com.devmasterteam.tasks.service.listener.TaskListener;
import com.devmasterteam.tasks.service.model.TaskModel;
import com.devmasterteam.tasks.view.viewholder.TaskViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private List<TaskModel> list = new ArrayList<>();
    private TaskListener listener;

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemTaskBinding item = ItemTaskBinding.inflate(inflater, parent, false);
        return new TaskViewHolder(item, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TaskModel taskModel = list.get(position);
        holder.bindData(taskModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Atribui o tratamento de eventos
     */
    public void attachListener(TaskListener listener) {
        this.listener = listener;
    }

    /**
     * Atualiza listagem
     */
    public void updateList(List<TaskModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

}
