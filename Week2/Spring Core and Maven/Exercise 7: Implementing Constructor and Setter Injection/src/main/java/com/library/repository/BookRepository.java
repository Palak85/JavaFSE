package com.library.repository;

public class BookRepository {
    public void save(String source) {
        System.out.println("BookRepository: Book record saved to the database via " + source + ".");
    }
}
