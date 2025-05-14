package com.devmasterteam.tasks.view.viewholder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devmasterteam.tasks.databinding.ItemTaskBinding;
import com.devmasterteam.tasks.service.listener.TaskListener;
import com.devmasterteam.tasks.service.model.TaskModel;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private final TaskListener listener;
    private final ItemTaskBinding binding;

    public TaskViewHolder(@NonNull ItemTaskBinding item, TaskListener listener) {
        super(item.getRoot());
        this.binding = item;
        this.listener = listener;
    }

    /**
     * Atribui valores aos elementos de interface e também eventos
     */
    public void bindData(final TaskModel task) {
    }
}