package com.library.model;

public class BorrowRecord {
    private String bookId;
    private String userId;

    public BorrowRecord(String bookId, String userId) {
        this.bookId = bookId;
        this.userId = userId;
    }
    public String getBookId() {
        return bookId;
    }
    public String getUserId() {
        return userId;
    }
    @Override
    public String toString() {
        return "bookId=" + bookId + ", userId=" + userId ;
    }
}
