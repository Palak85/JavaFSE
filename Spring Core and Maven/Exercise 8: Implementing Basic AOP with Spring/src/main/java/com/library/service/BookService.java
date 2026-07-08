package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via setter (Exercise 8).");
    }

    public void manageBook() {
        System.out.println("BookService: Managing books (Exercise 8)...");
        bookRepository.save();
    }
}
