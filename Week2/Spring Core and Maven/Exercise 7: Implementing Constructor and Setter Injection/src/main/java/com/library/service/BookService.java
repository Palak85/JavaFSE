package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String injectionType;

    // No-argument constructor
    public BookService() {
        this.injectionType = "Setter Injection";
        System.out.println("BookService: Default constructor called.");
    }

    // Constructor for constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.injectionType = "Constructor Injection";
        System.out.println("BookService: Constructor injection completed.");
    }

    // Setter for setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Setter injection completed.");
    }

    public void manageBook() {
        System.out.println("BookService: Managing books using service initialized with " + injectionType + "...");
        bookRepository.save(injectionType);
    }
}
