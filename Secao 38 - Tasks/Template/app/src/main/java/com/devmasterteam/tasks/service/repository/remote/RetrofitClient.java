package com.devmasterteam.tasks.service.repository.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit instance;

    private RetrofitClient() {
    }

    private static Retrofit getInstance() {
        synchronized (RetrofitClient.class) {
            if (instance == null) {
                instance = new retrofit2.Retrofit.Builder()
                        .baseUrl("https://www.devmasterteam.com/CursoAndroidAPI/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }
        return instance;
    }

}
