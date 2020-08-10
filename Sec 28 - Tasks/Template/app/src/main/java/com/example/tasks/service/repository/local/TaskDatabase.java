package com.example.tasks.service.repository.local;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class TaskDatabase extends RoomDatabase {

    // Singleton
    private static TaskDatabase INSTACE;

    // Singleton
    public static TaskDatabase getDataBase(Context context) {
        synchronized (TaskDatabase.class) {
            INSTACE = Room.databaseBuilder(context, TaskDatabase.class, "taskDB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTACE;
    }

}
