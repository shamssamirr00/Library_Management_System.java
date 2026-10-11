package com.library.service;
import com.library.model.Book;
import java.util.ArrayList;

public class ReportService {
    private BookService bookService;
    public  ReportService(BookService bookService){
        this.bookService = bookService;
    }
    public ArrayList<Book> getBorrowedBooks(){
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : bookService.getAllBooks()){
            if(!book.isAvailable()){
                result.add(book);
            }
        }
        return result;
    }
    public ArrayList<Book> getAvailableBooks(){
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : bookService.getAllBooks()){
            if(book.isAvailable()){
                result.add(book);
            }
        }
        return result;
    }
}
