package com.example.convidados.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.convidados.model.GuestModel;

import java.util.List;

@Dao
public interface GuestDAO {

    @Insert
    long insert(GuestModel guest);

    @Update
    int update(GuestModel guest);

    @Delete
    int delete(GuestModel guest);

    @Query("SELECT * FROM guest WHERE id = :id")
    GuestModel load(int id);

    @Query("SELECT * FROM guest")
    List<GuestModel> getAll();

    @Query("SELECT * FROM guest WHERE confirmation = :confirmation")
    List<GuestModel> getListByPresence(int confirmation);

}
