package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.devmasterteam.tasks.service.model.TaskModel;

public class TaskViewModel extends AndroidViewModel {

    public TaskViewModel(@NonNull Application application) {
        super(application);
    }

    public void getList() {
    }

    public void load(int id) {
    }

    public void save(TaskModel task) {
    }
}