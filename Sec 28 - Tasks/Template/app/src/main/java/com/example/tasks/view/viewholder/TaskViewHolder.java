package com.example.tasks.view.viewholder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasks.R;
import com.example.tasks.service.listener.TaskListener;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private SimpleDateFormat mDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private TaskListener mListener;

    public TaskViewHolder(@NonNull View itemView, TaskListener listener) {
        super(itemView);
        this.mListener = listener;
    }

    /**
     * Atribui valores aos elementos de interface e também eventos
     */
    public void bindData() {

        /*
        new AlertDialog.Builder(itemView.getContext())
                .setTitle(R.string.remocao_de_tarefa)
                .setMessage(R.string.remover_tarefa)
                .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // mListener.onDeleteClick(task.id);
                    }
                })
                .setNeutralButton(R.string.cancelar, null).show();*/


    }

}
