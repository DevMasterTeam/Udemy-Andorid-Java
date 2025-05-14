package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.tasks.service.listener.ApiListener;
import com.devmasterteam.tasks.service.listener.DBListener;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.service.model.PriorityModel;
import com.devmasterteam.tasks.service.model.TaskModel;
import com.devmasterteam.tasks.service.repository.PriorityRepository;
import com.devmasterteam.tasks.service.repository.TaskRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private final PriorityRepository priorityRepository;
    private final TaskRepository taskRepository;

    private final MutableLiveData<List<PriorityModel>> _listPriority = new MutableLiveData<>();
    public LiveData<List<PriorityModel>> listPriority = _listPriority;

    private final MutableLiveData<TaskModel> _task = new MutableLiveData<>();
    public LiveData<TaskModel> task = _task;

    private final MutableLiveData<Feedback> _feedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = _feedback;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        priorityRepository = new PriorityRepository(application);
        taskRepository = new TaskRepository(application);
    }

    public void getList() {
        priorityRepository.getList(new DBListener<List<PriorityModel>>() {
            @Override
            public void onSuccess(List<PriorityModel> result) {
                _listPriority.postValue(result);
            }
        });
    }

    public void load(int id) {
        taskRepository.load(id, new ApiListener<TaskModel>() {
            @Override
            public void onSuccess(TaskModel result) {
                _task.setValue(result);
            }

            @Override
            public void onFailure(String message) {
                _feedback.setValue(new Feedback(message));
            }
        });
    }

    public void save(TaskModel task) {
        ApiListener<Boolean> listener = new ApiListener<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                _feedback.setValue(new Feedback());
            }

            @Override
            public void onFailure(String message) {
                _feedback.setValue(new Feedback(message));
            }
        };

        if (task.getId() == 0) {
            taskRepository.create(task, listener);
        } else {
            taskRepository.update(task, listener);
        }
    }
}