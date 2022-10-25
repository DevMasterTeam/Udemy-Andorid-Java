package com.example.tasks.view.viewholder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasks.R;
import com.example.tasks.service.listener.TaskListener;
import com.example.tasks.service.model.TaskModel;
import com.example.tasks.service.repository.PriorityRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private PriorityRepository mPriorityRepository;
    private SimpleDateFormat mDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private TaskListener mListener;

    private ImageView mImageComplete = itemView.findViewById(R.id.image_complete);
    private TextView mTextDescription = itemView.findViewById(R.id.text_description);
    private TextView mTextPriority = itemView.findViewById(R.id.text_priority);
    private TextView mTextDueDate = itemView.findViewById(R.id.text_duedate);

    public TaskViewHolder(@NonNull View itemView, TaskListener listener) {
        super(itemView);
        this.mListener = listener;
        this.mPriorityRepository = new PriorityRepository(itemView.getContext());
    }

    /**
     * Atribui valores aos elementos de interface e também eventos
     */
    public void bindData(final TaskModel task) {

        this.mTextDescription.setText(task.getDescription());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(task.getDueDate());
            this.mTextDueDate.setText(this.mDateFormat.format(date));
        } catch (ParseException e) {
            this.mTextDueDate.setText("--");
        }

        String priority = this.mPriorityRepository.getDescription(task.getPriorityId());
        this.mTextPriority.setText(priority);

        if (task.getComplete()) {
            this.mImageComplete.setImageResource(R.drawable.ic_done);
            this.mTextDescription.setTextColor(Color.GRAY);
        } else {
            this.mImageComplete.setImageResource(R.drawable.ic_todo);
            this.mTextDescription.setTextColor(Color.BLACK);
        }

        this.mTextDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onListClick(task.getId());
            }
        });

        this.mTextDescription.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(itemView.getContext())
                        .setTitle(R.string.remocao_de_tarefa)
                        .setMessage(R.string.remover_tarefa)
                        .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mListener.onDeleteClick(task.getId());
                            }
                        })
                        .setNeutralButton(R.string.cancelar, null).show();
                return false;
            }
        });

        this.mImageComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (task.getComplete()) {
                    mListener.onUndoClick(task.getId());
                } else {
                    mListener.onCompleteClick(task.getId());
                }
            }
        });
    }

}
