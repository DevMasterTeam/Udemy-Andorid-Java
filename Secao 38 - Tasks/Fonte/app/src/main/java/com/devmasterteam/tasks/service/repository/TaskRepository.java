package com.devmasterteam.tasks.service.repository;

import android.content.Context;

import com.devmasterteam.tasks.service.listener.ApiListener;
import com.devmasterteam.tasks.service.model.TaskModel;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;
import com.devmasterteam.tasks.service.repository.remote.TaskService;

import java.util.List;

import retrofit2.Call;

public class TaskRepository extends BaseRepository {

    private final TaskService taskService;

    public TaskRepository(Context context) {
        super(context);
        taskService = RetrofitClient.createService(TaskService.class);
    }

    public void create(TaskModel taskModel, final ApiListener<Boolean> listener) {
        Call<Boolean> call = taskService.create(
                taskModel.getPriorityId(),
                taskModel.getDescription(),
                taskModel.getDueDate(),
                taskModel.isComplete()
        );
        super.execute(call, listener);
    }

    public void update(TaskModel taskModel, final ApiListener<Boolean> listener) {
        Call<Boolean> call = taskService.update(
                taskModel.getId(),
                taskModel.getPriorityId(),
                taskModel.getDescription(),
                taskModel.getDueDate(),
                taskModel.isComplete()
        );
        super.execute(call, listener);
    }

    public void delete(int id, final ApiListener<Boolean> listener) {
        Call<Boolean> call = taskService.delete(id);
        super.execute(call, listener);
    }

    public void complete(int id, final ApiListener<Boolean> listener) {
        Call<Boolean> call = taskService.complete(id);
        super.execute(call, listener);
    }

    public void undo(int id, final ApiListener<Boolean> listener) {
        Call<Boolean> call = taskService.undo(id);
        super.execute(call, listener);
    }

    public void all(final ApiListener<List<TaskModel>> listener) {
        Call<List<TaskModel>> call = taskService.all();
        super.execute(call, listener);
    }

    public void nextWeek(final ApiListener<List<TaskModel>> listener) {
        Call<List<TaskModel>> call = taskService.nextWeek();
        super.execute(call, listener);
    }

    public void overdue(final ApiListener<List<TaskModel>> listener) {
        Call<List<TaskModel>> call = taskService.overdue();
        super.execute(call, listener);
    }

    public void load(int id, final ApiListener<TaskModel> listener) {
        Call<TaskModel> call = taskService.load(id);
        super.execute(call, listener);
    }
}