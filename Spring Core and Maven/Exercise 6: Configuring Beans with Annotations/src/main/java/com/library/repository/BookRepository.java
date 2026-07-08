package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void save() {
        System.out.println("BookRepository: Book record has been successfully saved to the database (Exercise 6 - Annotation-based).");
    }
}
