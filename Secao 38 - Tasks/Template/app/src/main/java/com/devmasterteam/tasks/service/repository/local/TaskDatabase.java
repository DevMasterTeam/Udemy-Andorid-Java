package com.devmasterteam.tasks.service.repository.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.devmasterteam.tasks.service.model.PriorityModel;

// @Database(entities = {PriorityModel.class}, version = 1)
public abstract class TaskDatabase extends RoomDatabase {

    // DAO
    public abstract PriorityDAO priorityDAO();

    // Singleton
    public static TaskDatabase getDataBase(Context context) {
        TaskDatabase INSTANCE;
        synchronized (TaskDatabase.class) {
            INSTANCE = Room.databaseBuilder(context, TaskDatabase.class, "taskDB")
                    .build();
        }
        return INSTANCE;
    }

}
