package com.library.repository;

import com.library.model.Book;
import java.util.ArrayList;

public interface BookRepository {
    void addBook(Book book);
    Book findById(String id);

    ArrayList<Book> findAllBooks();
    void updateBook(Book book);
    void deleteBook(String id);
}
