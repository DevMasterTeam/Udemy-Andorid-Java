package com.example.apiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.apiexample.entity.APIResponseEntity;
import com.example.apiexample.entity.ParameterEntity;
import com.example.apiexample.entity.TaskEntity;
import com.example.apiexample.remote.External;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private External mExternal = new External();
    ParameterEntity mParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cria objeto de requisição com parâmetros
        String URL = "https://jsonplaceholder.typicode.com/todos";
        this.mParams = new ParameterEntity("GET", URL, null, null);

        this.list();
    }

    // Listagem
    public void list() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, Void, APIResponseEntity> task = new AsyncTask<Void, Void, APIResponseEntity>() {
            @Override
            protected APIResponseEntity doInBackground(Void... voids) {
                return mExternal.execute(mParams);
            }

            @Override
            protected void onPostExecute(APIResponseEntity apiResponseEntity) {

                String json = apiResponseEntity.getJson();
                List<TaskEntity> lst = new Gson().fromJson(json, new TypeToken<List<TaskEntity>>() {
                }.getType());

                super.onPostExecute(apiResponseEntity);
            }
        };

        // Executa async
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}