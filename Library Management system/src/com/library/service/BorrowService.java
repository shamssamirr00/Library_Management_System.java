package com.library.service;
import com.library.model.Book;
import com.library.model.User;
import com.library.model.BorrowRecord;

import java.util.ArrayList;

public class
BorrowService {
    private BookService bookService;
    private UserService userService;

    private ArrayList <BorrowRecord>  borrowRecords;
    public BorrowService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
        borrowRecords = new ArrayList<>();
    }
    public boolean borrowBook(String bookId, String userId){
        Book book = bookService.findBookById(bookId);
        User user = userService.findUserById(userId);
        if (book == null || user == null) {
            return false;
        }
        if (!book.isAvailable()){
            return false;
        }
        book.setAvailable(false);
        BorrowRecord record = new BorrowRecord(bookId , userId);
        borrowRecords.add(record);
        return true;
    }
    public boolean returnBook(String bookId){
        Book book = bookService.findBookById(bookId);
        if (book == null || book.isAvailable()) {
            return false;
        }
        book.setAvailable(true);
        for (int i = 0 ; i < borrowRecords.size(); i++) {
            if (borrowRecords.get(i).getBookId().equals(bookId)) {
                borrowRecords.remove(i);
                break;
            }
        }
        return true;
    }
    public ArrayList <BorrowRecord> getBorrowRecords(){
        return borrowRecords;
    }
}

