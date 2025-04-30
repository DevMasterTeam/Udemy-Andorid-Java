package com.devmasterteam.mybooks.entity;

public class BookEntity {

    private final int id;
    private final String title;
    private final String author;
    private boolean favorite;
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