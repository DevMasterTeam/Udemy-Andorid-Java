package com.example.tasks.service.repository.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tasks.service.model.PriorityModel;

@Database(entities = {PriorityModel.class}, version = 1)
public abstract class TaskDatabase extends RoomDatabase {

    // Singleton
    private static TaskDatabase INSTANCE;

    // DAO
    public abstract PriorityDAO priorityDAO();

    // Singleton
    public static TaskDatabase getDataBase(Context context) {
        synchronized (TaskDatabase.class) {
            INSTANCE = Room.databaseBuilder(context, TaskDatabase.class, "taskDB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

}
