package com.devmasterteam.tasks.service.repository;

import android.content.Context;

import com.devmasterteam.tasks.service.listener.ApiListener;
import com.devmasterteam.tasks.service.listener.DBListener;
import com.devmasterteam.tasks.service.model.PriorityModel;
import com.devmasterteam.tasks.service.repository.local.PriorityDAO;
import com.devmasterteam.tasks.service.repository.local.TaskDatabase;
import com.devmasterteam.tasks.service.repository.remote.PriorityService;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;

public class PriorityRepository extends BaseRepository {

    private final PriorityService priorityService;
    private final PriorityDAO priorityDAO;
    private final Executor executor = Executors.newSingleThreadExecutor();

    public PriorityRepository(Context context) {
        super(context);
        this.context = context;
        priorityService = RetrofitClient.createService(PriorityService.class);
        priorityDAO = TaskDatabase.getDataBase(context).priorityDAO();
    }

    private static final Map<Integer, String> cache = new HashMap<>();

    public static String getCachedDescription(int id) {
        return cache.getOrDefault(id, "");
    }

    public static void setCachedDescription(int id, String str) {
        cache.put(id, str);
    }

    public void all(final ApiListener<List<PriorityModel>> listener) {
        Call<List<PriorityModel>> call = priorityService.all();
        super.execute(call, listener);
    }

    public void getList(DBListener<List<PriorityModel>> callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(priorityDAO.list());
            }
        });
    }

    public void getDescription(int id, DBListener<String> callback) {
        // Verifica cache
        String cached = getCachedDescription(id);
        if (!cached.isEmpty()) {
            callback.onSuccess(cached);
            return;
        }

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String description = priorityDAO.getDescription(id);
                setCachedDescription(id, description);
                callback.onSuccess(description);
            }
        });
    }

    public void save(List<PriorityModel> list) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                priorityDAO.clear();
                priorityDAO.save(list);
            }
        });
    }

}