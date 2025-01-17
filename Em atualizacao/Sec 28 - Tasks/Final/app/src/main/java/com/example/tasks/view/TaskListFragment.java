package com.example.tasks.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasks.R;
import com.example.tasks.service.constants.TaskConstants;
import com.example.tasks.service.listener.Feedback;
import com.example.tasks.service.listener.TaskListener;
import com.example.tasks.service.model.TaskModel;
import com.example.tasks.view.adapter.TaskAdapter;
import com.example.tasks.viewmodel.TaskListViewModel;

import java.util.List;

public class TaskListFragment extends Fragment {

    private TaskAdapter mAdapter = new TaskAdapter();
    private TaskListViewModel mViewModel;
    private TaskListener mListener;
    private int mFilter = 0;

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
                Intent intent = new Intent(getContext(), TaskActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(TaskConstants.BUNDLE.TASKID, id);
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int id) {
                mViewModel.delete(id);
            }

            @Override
            public void onCompleteClick(int id) {
                mViewModel.updateStatus(id, true);
            }

            @Override
            public void onUndoClick(int id) {
                mViewModel.updateStatus(id, false);
            }
        };
        this.mAdapter.attachListener(this.mListener);

        // Cria os observadores
        this.loadObservers();

        Bundle bundle = getArguments();
        if (bundle != null) {
            this.mFilter = bundle.getInt(TaskConstants.TASKFILTER.KEY);
        }

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mViewModel.list(this.mFilter);
    }

    private void loadObservers() {
        this.mViewModel.list.observe(getViewLifecycleOwner(), new Observer<List<TaskModel>>() {
            @Override
            public void onChanged(List<TaskModel> taskModels) {
                mAdapter.updateList(taskModels);
            }
        });

        this.mViewModel.feedback.observe(getViewLifecycleOwner(), new Observer<Feedback>() {
            @Override
            public void onChanged(Feedback feedback) {
                if (!feedback.isSuccess()) {
                    toast(feedback.getMessage());
                } else {
                    toast(getString(R.string.task_removed));
                }
            }
        });
    }

    private void toast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}