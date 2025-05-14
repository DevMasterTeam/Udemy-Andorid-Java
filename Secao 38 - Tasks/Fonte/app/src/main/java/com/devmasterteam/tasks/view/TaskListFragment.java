package com.devmasterteam.tasks.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.devmasterteam.tasks.databinding.FragmentTaskListBinding;
import com.devmasterteam.tasks.service.listener.TaskListener;
import com.devmasterteam.tasks.view.adapter.TaskAdapter;
import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.service.model.TaskModel;
import com.devmasterteam.tasks.viewmodel.TaskListViewModel;

import java.util.List;

public class TaskListFragment extends Fragment {

    private FragmentTaskListBinding binding;
    private final TaskAdapter adapter = new TaskAdapter();
    private TaskListViewModel viewModel;
    private int filter = 0;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle b) {
        viewModel = new ViewModelProvider(this).get(TaskListViewModel.class);
        binding = FragmentTaskListBinding.inflate(inflater, container, false);

        // Lista de tarefas
        binding.recyclerTaskList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerTaskList.setAdapter(adapter);

        TaskListener listener = new TaskListener() {
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
                viewModel.delete(id);
            }

            @Override
            public void onCompleteClick(int id) {
                viewModel.updateStatus(id, true);
            }

            @Override
            public void onUndoClick(int id) {
                viewModel.updateStatus(id, false);
            }
        };

        adapter.attachListener(listener);

        // Cria os observadores
        loadObservers();

        Bundle bundle = getArguments();
        if (bundle != null) {
            filter = bundle.getInt(TaskConstants.TASKFILTER.KEY);
        }

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.list(filter);
    }

    private void loadObservers() {
        viewModel.list.observe(getViewLifecycleOwner(), new Observer<List<TaskModel>>() {
            @Override
            public void onChanged(List<TaskModel> taskModels) {
                adapter.updateList(taskModels);
            }
        });

        viewModel.feedback.observe(getViewLifecycleOwner(), new Observer<Feedback>() {
            @Override
            public void onChanged(Feedback feedback) {
                if (!feedback.isSuccess()) {
                    toast(feedback.getMessage());
                } else {
                    toast(getString(R.string.msg_task_removed));
                }
            }
        });
    }

    private void toast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}