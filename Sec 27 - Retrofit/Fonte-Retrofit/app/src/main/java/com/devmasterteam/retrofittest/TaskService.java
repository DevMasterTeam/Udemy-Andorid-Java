package com.devmasterteam.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TaskService {

    @GET("/todos")
    Call<List<TaskEntity>> list();

}
