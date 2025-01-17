package com.example.tasks.service.repository.remote;

import com.example.tasks.service.model.TaskModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TaskService {

    @GET("Task")
    Call<List<TaskModel>> all();

    @GET("Task/Next7Days")
    Call<List<TaskModel>> nextWeek();

    @GET("Task/Overdue")
    Call<List<TaskModel>> overdue();

    @GET("Task/{id}")
    Call<TaskModel> load(@Path(value = "id", encoded = true) int id);

    @FormUrlEncoded
    @POST("Task")
    Call<Boolean> create(
            @Field("PriorityId") int priorityId,
            @Field("Description") String description,
            @Field("DueDate") String dueDate,
            @Field("Complete") Boolean complete);

    @FormUrlEncoded
    @PUT("Task")
    Call<Boolean> update(
            @Field("Id") int id,
            @Field("PriorityId") int priorityId,
            @Field("Description") String description,
            @Field("DueDate") String dueDate,
            @Field("Complete") Boolean complete);

    @FormUrlEncoded
    @PUT("Task/Complete")
    Call<Boolean> complete(@Field("Id") int id);

    @FormUrlEncoded
    @PUT("Task/Undo")
    Call<Boolean> undo(@Field("Id") int id);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Task", hasBody = true)
    Call<Boolean> delete(@Field("Id") int id);

}