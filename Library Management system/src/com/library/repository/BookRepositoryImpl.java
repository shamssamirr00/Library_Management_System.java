package com.library.repository;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.HashMap;

public class BookRepositoryImpl implements BookRepository {
    private ArrayList<Book> books;
    private HashMap<String , Book> bookMap;

    public BookRepositoryImpl() {
        books = new ArrayList<>();
        bookMap = new HashMap<>();
    }
    @Override
    public void addBook(Book book) {
        books.add(book);
        bookMap.put(book.getId() , book);
    }
    @Override
    public Book findById(String id) {
        return bookMap.get(id);
    }
    @Override
    public ArrayList<Book> findAllBooks() {
        return books;
    }
    @Override
    public void updateBook(Book book) {
        bookMap.put(book.getId() , book);
    }
    @Override
    public void deleteBook(String id) {
        Book book = bookMap.remove(id);

        if (book != null) {
            books.remove(book);
        }
    }
}
