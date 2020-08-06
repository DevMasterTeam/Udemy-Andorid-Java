package com.devmasterteam.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TaskService mTaskService = RetrofitClient.createService(TaskService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<List<TaskEntity>> call = mTaskService.list();
        call.enqueue(new Callback<List<TaskEntity>>() {
            @Override
            public void onResponse(Call<List<TaskEntity>> call, Response<List<TaskEntity>> response) {
                List<TaskEntity> lst = response.body();
                int size = lst.size();
            }

            @Override
            public void onFailure(Call<List<TaskEntity>> call, Throwable t) {
                String s = t.getMessage();
            }
        });

    }

}
