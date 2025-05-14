package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.tasks.service.model.TaskModel;

import java.util.List;

public class TaskListViewModel extends AndroidViewModel {

    private int filter = 0;

    private final MutableLiveData<List<TaskModel>> _list = new MutableLiveData<>();
    public LiveData<List<TaskModel>> list = _list;

    public TaskListViewModel(@NonNull Application application) {
        super(application);
    }

    public void list(int filter) {
        this.filter = filter;
    }
}