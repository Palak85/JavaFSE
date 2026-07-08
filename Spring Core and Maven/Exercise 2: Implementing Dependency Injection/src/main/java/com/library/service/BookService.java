package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository has been wired/injected via setter method.");
    }

    public void manageBook() {
        System.out.println("BookService: Processing book management operation...");
        bookRepository.save();
    }
}
