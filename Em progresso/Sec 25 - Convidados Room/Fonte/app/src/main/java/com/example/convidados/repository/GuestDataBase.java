package com.example.convidados.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.convidados.model.GuestModel;

@Database(entities = {GuestModel.class}, version = 1)
public abstract class GuestDataBase extends RoomDatabase {

    public static GuestDataBase INSTANCE;

    public abstract GuestDAO guestDAO();

    public static GuestDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, GuestDataBase.class, "convidados")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                        }
                    })
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }

        return INSTANCE;
    }

    private static Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

}
