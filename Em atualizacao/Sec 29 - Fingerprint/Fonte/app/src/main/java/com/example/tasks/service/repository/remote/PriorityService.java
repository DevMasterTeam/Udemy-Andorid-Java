package com.example.tasks.service.repository.remote;

import com.example.tasks.service.model.PriorityModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PriorityService {

    @GET("Priority")
    Call<List<PriorityModel>> all();

}