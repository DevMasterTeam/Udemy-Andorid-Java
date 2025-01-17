package com.example.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tasks.service.constants.TaskConstants;
import com.example.tasks.service.listener.APIListener;
import com.example.tasks.service.listener.Feedback;
import com.example.tasks.service.model.TaskModel;
import com.example.tasks.service.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskListViewModel extends AndroidViewModel {

    private TaskRepository mTaskRepository;
    private int mFilter = 0;

    private MutableLiveData<List<TaskModel>> mList = new MutableLiveData<>();
    public LiveData<List<TaskModel>> list = this.mList;

    private MutableLiveData<Feedback> mFeedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = this.mFeedback;

    public TaskListViewModel(@NonNull Application application) {
        super(application);
        this.mTaskRepository = new TaskRepository(application);
    }

    public void list(int filter) {
        this.mFilter = filter;
        APIListener<List<TaskModel>> listener = new APIListener<List<TaskModel>>() {
            @Override
            public void onSuccess(List<TaskModel> result) {
                mList.setValue(result);
            }

            @Override
            public void onFailure(String message) {
                mList.setValue(new ArrayList<TaskModel>());
                mFeedback.setValue(new Feedback(message));
            }
        };

        if (filter == TaskConstants.TASKFILTER.NO_FILTER) {
            this.mTaskRepository.all(listener);
        } else if (filter == TaskConstants.TASKFILTER.NEXT_7_DAYS) {
            this.mTaskRepository.nextWeek(listener);
        } else {
            this.mTaskRepository.overdue(listener);
        }
    }

    public void updateStatus(int id, boolean complete) {
        APIListener<Boolean> listener = new APIListener<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                list(mFilter);
            }

            @Override
            public void onFailure(String message) {
                mFeedback.setValue(new Feedback(message));
            }
        };

        if (complete) {
            this.mTaskRepository.complete(id, listener);
        } else {
            this.mTaskRepository.undo(id, listener);
        }
    }

    public void delete(int id) {
        this.mTaskRepository.delete(id, new APIListener<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                list(mFilter);
                mFeedback.setValue(new Feedback());
            }

            @Override
            public void onFailure(String message) {
                mFeedback.setValue(new Feedback(message));
            }
        });
    }

}