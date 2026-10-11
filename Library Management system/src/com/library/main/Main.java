package com.library.main;

import com.library.model.Book;
import com.library.model.User;

import com.library.repository.BookRepository;
import com.library.repository.BookRepositoryImpl;
import com.library.repository.UserRepository;
import com.library.repository.UserRepositoryImpl;

import com.library.service.BookService;
import com.library.service.UserService;
import com.library.service.BorrowService;
import com.library.service.ReportService;

import com.library.util.InputUtil;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        InputUtil input = new InputUtil();

        BookRepository bookRepository =
                new BookRepositoryImpl();

        UserRepository userRepository =
                new UserRepositoryImpl();

        BookService bookService =
                new BookService(bookRepository);

        UserService userService =
                new UserService(userRepository);

        BorrowService borrowService =
                new BorrowService(bookService, userService);

        ReportService reportService =
                new ReportService(bookService);

        int choice;

        do {
            showMenu();
            choice = input.readInt("Choose an option: ");

            switch (choice) {

                case 1:
                    addBook(input, bookService);
                    break;

                case 2:
                    viewBooks(bookService);
                    break;

                case 3:
                    updateBook(input, bookService);
                    break;

                case 4:
                    deleteBook(input, bookService);
                    break;

                case 5:
                    searchBook(input, bookService);
                    break;

                case 6:
                    registerUser(input, userService);
                    break;

                case 7:
                    viewUsers(userService);
                    break;

                case 8:
                    borrowBook(input, borrowService);
                    break;

                case 9:
                    returnBook(input, borrowService);
                    break;

                case 10:
                    reports(reportService);
                    break;

                case 0:
                    System.out.println("Goodbye!!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 0);
    }

    private static void showMenu() {

        System.out.println("\n===== Library Management System =====");

        System.out.println("1. Add New Book");
        System.out.println("2. View All Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Search Book");
        System.out.println("6. Register New User");
        System.out.println("7. View All Users");
        System.out.println("8. Borrow Book");
        System.out.println("9. Return Book");
        System.out.println("10. Reports");
        System.out.println("0. Exit");

        System.out.println("=====================================");
    }

    private static void addBook(InputUtil input,
                                BookService bookService) {

        String id = input.readString("Enter Book ID: ");
        String isbn = input.readString("Enter ISBN: ");
        String title = input.readString("Enter Title: ");
        String author = input.readString("Enter Author: ");
        String category = input.readString("Enter Category: ");

        Book book =
                new Book(id, isbn, title, author, category);

        if (bookService.addBook(book)) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book ID or ISBN already exists.");
        }
    }

    private static void viewBooks(BookService bookService) {

        ArrayList<Book> books =
                bookService.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book book : books) {

            System.out.println("--------------------");
            System.out.println(book);
        }
    }

    private static void updateBook(InputUtil input,
                                   BookService bookService) {

        String id =
                input.readString("Enter Book ID: ");

        String title =
                input.readString("Enter New Title: ");

        String author =
                input.readString("Enter New Author: ");

        String category =
                input.readString("Enter New Category: ");

        if (bookService.updateBook(
                id, title, author, category)) {

            System.out.println("Book updated successfully.");

        } else {

            System.out.println("Book not found.");
        }
    }

    private static void deleteBook(InputUtil input,
                                   BookService bookService) {

        String id =
                input.readString("Enter Book ID: ");

        if (bookService.deleteBookById(id)) {

            System.out.println("Book deleted successfully.");

        } else {

            System.out.println("Book not found.");
        }
    }

    private static void searchBook(InputUtil input,
                                   BookService bookService) {

        System.out.println("\n1. Search by Title");
        System.out.println("2. Search by Author");
        System.out.println("3. Search by Category");

        int choice =
                input.readInt("Choose search type: ");

        String value =
                input.readString("Enter search value: ");

        ArrayList<Book> result;

        switch (choice) {

            case 1:
                result =
                        bookService.searchByTitle(value);
                break;

            case 2:
                result =
                        bookService.searchByAuthor(value);
                break;

            case 3:
                result =
                        bookService.searchByCategory(value);
                break;

            default:
                System.out.println("Invalid search option.");
                return;
        }

        if (result.isEmpty()) {

            System.out.println("No books found.");

        } else {

            for (Book book : result) {

                System.out.println("--------------------");
                System.out.println(book);
            }
        }
    }

    private static void registerUser(InputUtil input,
                                     UserService userService) {

        String id =
                input.readString("Enter User ID: ");

        String name =
                input.readString("Enter User Name: ");

        User user =
                new User(id, name);

        if (userService.registerUser(user)) {

            System.out.println("User registered successfully.");

        } else {

            System.out.println("User ID already exists.");
        }
    }

    private static void viewUsers(UserService userService) {

        ArrayList<User> users =
                userService.getAllUsers();

        if (users.isEmpty()) {

            System.out.println("No users found.");
            return;
        }

        for (User user : users) {

            System.out.println("--------------------");
            System.out.println(user);
        }
    }

    private static void borrowBook(InputUtil input,
                                   BorrowService borrowService) {

        String bookId =
                input.readString("Enter Book ID: ");

        String userId =
                input.readString("Enter User ID: ");

        if (borrowService.borrowBook(bookId, userId)) {

            System.out.println("Book borrowed successfully.");

        } else {

            System.out.println("Cannot borrow book.");
        }
    }

    private static void returnBook(InputUtil input,
                                   BorrowService borrowService) {

        String bookId =
                input.readString("Enter Book ID: ");

        if (borrowService.returnBook(bookId)) {

            System.out.println("Book returned successfully.");

        } else {

            System.out.println("Cannot return book.");
        }
    }

    private static void reports(ReportService reportService) {

        System.out.println("\n===== Borrowed Books =====");

        ArrayList<Book> borrowedBooks =
                reportService.getBorrowedBooks();

        if (borrowedBooks.isEmpty()) {

            System.out.println("No borrowed books.");

        } else {

            for (Book book : borrowedBooks) {

                System.out.println("--------------------");
                System.out.println(book);
            }
        }

        System.out.println("\n===== Available Books =====");

        ArrayList<Book> availableBooks =
                reportService.getAvailableBooks();

        if (availableBooks.isEmpty()) {

            System.out.println("No available books.");

        } else {

            for (Book book : availableBooks) {

                System.out.println("-----------------");
                System.out.println(book);
            }
        }
    }
}
