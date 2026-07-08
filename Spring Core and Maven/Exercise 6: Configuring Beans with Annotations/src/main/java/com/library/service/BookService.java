package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository has been autowired via setter injection (Exercise 6).");
    }

    public void manageBook() {
        System.out.println("BookService: Processing book management operation (Exercise 6)...");
        bookRepository.save();
    }
}
