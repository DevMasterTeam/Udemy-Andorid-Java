package com.example.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TaskListViewModel extends AndroidViewModel {

    public TaskListViewModel(@NonNull Application application) {
        super(application);
    }

}