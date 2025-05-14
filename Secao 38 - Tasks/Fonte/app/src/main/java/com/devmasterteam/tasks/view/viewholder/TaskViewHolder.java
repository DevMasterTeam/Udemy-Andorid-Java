package com.devmasterteam.tasks.view.viewholder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.databinding.ItemTaskBinding;
import com.devmasterteam.tasks.service.listener.DBListener;
import com.devmasterteam.tasks.service.listener.TaskListener;
import com.devmasterteam.tasks.service.model.TaskModel;
import com.devmasterteam.tasks.service.repository.PriorityRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private final PriorityRepository priorityRepository;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private final TaskListener listener;
    private final ItemTaskBinding binding;

    public TaskViewHolder(@NonNull ItemTaskBinding item, TaskListener listener) {
        super(item.getRoot());
        this.binding = item;
        this.listener = listener;
        priorityRepository = new PriorityRepository(itemView.getContext());
    }

    /**
     * Atribui valores aos elementos de interface e também eventos
     */
    public void bindData(final TaskModel task) {

        binding.textDescription.setText(task.getDescription());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(task.getDueDate());
            binding.textDuedate.setText(dateFormat.format(date));
        } catch (ParseException e) {
            binding.textDuedate.setText("--");
        }

        priorityRepository.getDescription(task.getPriorityId(), new DBListener<String>() {
            @Override
            public void onSuccess(String result) {
                ((Activity) binding.textPriority.getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.textPriority.setText(result);
                    }
                });
            }
        });

        if (task.isComplete()) {
            binding.imageComplete.setImageResource(R.drawable.ic_done);
            binding.textDescription.setTextColor(Color.GRAY);
        } else {
            binding.imageComplete.setImageResource(R.drawable.ic_todo);
            binding.textDescription.setTextColor(Color.BLACK);
        }

        binding.textDescription.setOnClickListener(v -> listener.onListClick(task.getId()));
        binding.textDescription.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(itemView.getContext())
                        .setTitle(R.string.title_task_removal)
                        .setMessage(R.string.label_remove_task)
                        .setPositiveButton(R.string.button_yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onDeleteClick(task.getId());
                            }
                        })
                        .setNeutralButton(R.string.button_cancel, null).show();
                return false;
            }
        });

        binding.imageComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (task.isComplete()) {
                    listener.onUndoClick(task.getId());
                } else {
                    listener.onCompleteClick(task.getId());
                }
            }
        });
    }
}