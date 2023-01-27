package com.genspark.kafka.apachekafkaproducerdemo;

public class Book {
    public Book(String bookName,String isbn) {
        this.bookName = bookName;
        this.isbn=isbn;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    private String bookName;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    private String isbn;
}
