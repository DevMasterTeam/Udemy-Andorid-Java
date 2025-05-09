package com.devmasterteam.mybooks.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.devmasterteam.mybooks.entity.BookEntity;

import java.util.List;

@Dao
public interface BookDAO {

    @Insert
    void create(List<BookEntity> book);

    @Update
    int update(BookEntity book);

    @Delete
    int delete(BookEntity book);

    @Query("SELECT * FROM Book WHERE id = :id")
    BookEntity getBookById(int id);

    @Query("SELECT * FROM Book")
    List<BookEntity> getAllBooks();

    @Query("SELECT * FROM Book WHERE favorite = 1")
    List<BookEntity> getFavoriteBooks();
}
