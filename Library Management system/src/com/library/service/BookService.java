package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;

import java.util.ArrayList;
import java.util.HashSet;

public class BookService {
    private BookRepository  bookRepository;
    private HashSet< String > bookIds;
    private HashSet< String > isbns;

    public BookService(BookRepository bookRepository ) {
        this.bookRepository = bookRepository;
        bookIds = new HashSet<>();
        isbns = new HashSet<>();
    }
    public boolean addBook(Book book) {
        if(bookIds.contains(book.getId())) {
            return false;
        }
        if(isbns.contains(book.getIsbn())) {
            return false;
        }
        bookRepository .addBook(book);
        bookIds.add(book.getId());
        isbns.add(book.getIsbn());
        return true;
    }
    public ArrayList<Book> getAllBooks() {
        return bookRepository.findAllBooks();
    }
    public Book findBookById(String id) {
        return bookRepository.findById(id);
    }
    public boolean updateBook(String id, String title , String author, String category ){
        Book book = bookRepository.findById(id);

        if (book == null) {
            return false;
        }
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        bookRepository.updateBook(book);
        return true;
    }
    public boolean deleteBookById(String id) {
        Book book = bookRepository.findById(id);
        if (book == null) {
            return false;
        }
        bookRepository.deleteBook(id);

        bookIds.remove(id);
        isbns.remove(book.getIsbn());
        return true;
    }
    public ArrayList <Book> searchByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : bookRepository.findAllBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }
    public ArrayList <Book> searchByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : bookRepository.findAllBooks()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
    public ArrayList <Book> searchByCategory(String category) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : bookRepository.findAllBooks()) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }
}
