package com.devmasterteam.tasks.service.repository.remote;

import com.devmasterteam.tasks.service.model.PriorityModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PriorityService {

    @GET("Priority")
    Call<List<PriorityModel>> all();

}