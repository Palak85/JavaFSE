package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository has been wired/injected via setter (Exercise 5).");
    }

    public void manageBook() {
        System.out.println("BookService: Processing book management operation (Exercise 5)...");
        bookRepository.save();
    }
}
