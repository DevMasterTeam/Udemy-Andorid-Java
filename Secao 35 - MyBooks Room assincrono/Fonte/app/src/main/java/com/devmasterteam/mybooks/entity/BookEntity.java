package com.devmasterteam.mybooks.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Book")
public class BookEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private final int id;

    @ColumnInfo(name = "title")
    private final String title;

    @ColumnInfo(name = "author")
    private final String author;

    @ColumnInfo(name = "favorite")
    private boolean favorite;

    @ColumnInfo(name = "genre")
    private final String genre;

    public BookEntity(int id, String title, String author, boolean favorite, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.favorite = favorite;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getGenre() {
        return genre;
    }
}