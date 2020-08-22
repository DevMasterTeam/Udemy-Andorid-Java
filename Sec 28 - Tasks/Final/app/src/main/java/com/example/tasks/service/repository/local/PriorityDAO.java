package com.example.tasks.service.repository.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tasks.service.model.PriorityModel;

import java.util.List;

@Dao
public interface PriorityDAO {

    @Insert
    void save(List<PriorityModel> list);

    @Query("SELECT * FROM priority")
    List<PriorityModel> list();

    @Query("SELECT description FROM priority WHERE id = :id")
    String getDescription(int id);

    @Query("DELETE FROM priority")
    void clear();

}
