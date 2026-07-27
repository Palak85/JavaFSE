package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository has been wired/injected via setter (Exercise 3).");
    }

    public void manageBook() {
        System.out.println("BookService: Processing book management operation (Exercise 3)...");
        try {
            // Introduce a small delay to simulate method execution time
            Thread.sleep(150);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        bookRepository.save();
    }
}
