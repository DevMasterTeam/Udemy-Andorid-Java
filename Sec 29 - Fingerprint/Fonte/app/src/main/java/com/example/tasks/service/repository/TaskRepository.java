package com.example.tasks.service.repository;

import android.content.Context;

import com.example.tasks.R;
import com.example.tasks.service.constants.TaskConstants;
import com.example.tasks.service.listener.APIListener;
import com.example.tasks.service.model.TaskModel;
import com.example.tasks.service.repository.remote.RetrofitClient;
import com.example.tasks.service.repository.remote.TaskService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskRepository extends BaseRepository {

    private TaskService mTaskService;

    public TaskRepository(Context context) {
        super(context);
        this.mTaskService = RetrofitClient.createService(TaskService.class);
    }

    private void persist(Call<Boolean> call, final APIListener<Boolean> listener) {

        if (!super.isConnectionAvailable()) {
            listener.onFailure(mContext.getString(R.string.ERROR_INTERNET_CONNECTION));
            return;
        }

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(handleFailure(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                listener.onFailure(mContext.getString(R.string.ERROR_UNEXPECTED));
            }
        });
    }

    public void create(TaskModel taskModel, final APIListener<Boolean> listener) {
        Call<Boolean> call = mTaskService.create(
                taskModel.getPriorityId(),
                taskModel.getDescription(),
                taskModel.getDueDate(),
                taskModel.getComplete()
        );
        this.persist(call, listener);
    }

    public void update(TaskModel taskModel, final APIListener<Boolean> listener) {
        Call<Boolean> call = mTaskService.update(
                taskModel.getId(),
                taskModel.getPriorityId(),
                taskModel.getDescription(),
                taskModel.getDueDate(),
                taskModel.getComplete()
        );
        this.persist(call, listener);
    }

    public void delete(int id, final APIListener<Boolean> listener) {
        Call<Boolean> call = this.mTaskService.delete(id);
        this.persist(call, listener);
    }

    public void complete(int id, final APIListener<Boolean> listener) {
        Call<Boolean> call = this.mTaskService.complete(id);
        this.persist(call, listener);
    }

    public void undo(int id, final APIListener<Boolean> listener) {
        Call<Boolean> call = this.mTaskService.undo(id);
        this.persist(call, listener);
    }

    private void list(Call<List<TaskModel>> call, final APIListener<List<TaskModel>> listener) {

        if (!super.isConnectionAvailable()) {
            listener.onFailure(mContext.getString(R.string.ERROR_INTERNET_CONNECTION));
            return;
        }

        call.enqueue(new Callback<List<TaskModel>>() {
            @Override
            public void onResponse(Call<List<TaskModel>> call, Response<List<TaskModel>> response) {
                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(handleFailure(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<List<TaskModel>> call, Throwable t) {
                listener.onFailure(mContext.getString(R.string.ERROR_UNEXPECTED));
            }
        });
    }

    public void all(final APIListener<List<TaskModel>> listener) {
        Call<List<TaskModel>> call = this.mTaskService.all();
        this.list(call, listener);
    }

    public void nextWeek(final APIListener<List<TaskModel>> listener) {
        Call<List<TaskModel>> call = this.mTaskService.nextWeek();
        this.list(call, listener);
    }

    public void overdue(final APIListener<List<TaskModel>> listener) {
        Call<List<TaskModel>> call = this.mTaskService.overdue();
        this.list(call, listener);
    }

    public void load(int id, final APIListener<TaskModel> listener) {

        if (!super.isConnectionAvailable()) {
            listener.onFailure(mContext.getString(R.string.ERROR_INTERNET_CONNECTION));
            return;
        }

        Call<TaskModel> call = this.mTaskService.load(id);
        call.enqueue(new Callback<TaskModel>() {
            @Override
            public void onResponse(Call<TaskModel> call, Response<TaskModel> response) {
                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(handleFailure(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<TaskModel> call, Throwable t) {
                listener.onFailure(mContext.getString(R.string.ERROR_UNEXPECTED));
            }
        });
    }

}
