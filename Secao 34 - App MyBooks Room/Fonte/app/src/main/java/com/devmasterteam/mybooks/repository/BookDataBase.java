package com.devmasterteam.mybooks.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.devmasterteam.mybooks.entity.BookEntity;

@Database(entities = {BookEntity.class}, version = 1)
public abstract class BookDataBase extends RoomDatabase {

    // Data Access Object
    public abstract BookDAO bookDAO();

    private static final String DATABASE_NAME = "books_db";

    // Instância do banco de dados (padrão Singleton)
    private static BookDataBase instance;

    // Método para obter a instância do banco de dados
    public static BookDataBase getDatabase(final Context context) {
        synchronized (BookDataBase.class) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                                BookDataBase.class, DATABASE_NAME)
                        .addCallback(MyBooksDBCallback.creation)
                        .addMigrations(Migrations.migrationFromV1ToV2)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return instance;
    }

    /**
     * Migrações
     */
    private static class Migrations {
        /**
         * Atualização de versão de banco de dados
         */
        public static final Migration migrationFromV1ToV2 = new Migration(1, 2) {
            @Override
            public void migrate(SupportSQLiteDatabase db) {
                // Limpar o banco de dados
                db.execSQL("DELETE FROM Book");

                // Criar uma nova coluna, atualizar valores, etc.
                // Qualquer tipo de lógica de banco de dados para garantir a atualização de versão
            }
        };
    }

    /**
     * Callback de criação
     */
    private static class MyBooksDBCallback {
        private static final RoomDatabase.Callback creation = new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                // Qualquer lógica necessária para ser executada durante a criação do banco
            }
        };
    }
}
