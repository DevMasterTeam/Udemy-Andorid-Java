package com.example.tasks.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasks.R;
import com.example.tasks.service.listener.TaskListener;
import com.example.tasks.view.adapter.TaskAdapter;
import com.example.tasks.viewmodel.TaskListViewModel;

public class TaskListFragment extends Fragment {

    private TaskAdapter mAdapter = new TaskAdapter();
    private TaskListViewModel mViewModel;
    private TaskListener mListener;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_list, container, false);
        this.mViewModel = new ViewModelProvider(this).get(TaskListViewModel.class);

        // Lista de tarefas
        RecyclerView recycler = root.findViewById(R.id.recycler_task_list);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(this.mAdapter);

        this.mListener = new TaskListener() {
            @Override
            public void onListClick(int id) {
            }

            @Override
            public void onDeleteClick(int id) {
            }

            @Override
            public void onCompleteClick(int id) {
            }

            @Override
            public void onUndoClick(int id) {
            }
        };

        // Cria os observadores
        this.loadObservers();

        return root;
    }

    private void loadObservers() {
    }

    private void toast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}