package com.library.model;

public class Book {
    private String id;
    private String isbn;
    private String title;
    private String author;
    private String category;
    private boolean available;

    public Book(String id, String isbn, String title, String author, String category) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ID : " + id +
                "\n ISBN : " + isbn +
                "\n Title : " + title +
                "\n Author : " + author +
                "\n Category : " + category +
                "\n Status : " +
                        (available ? "Available" : " Borrowed");
    }
}