package com.lee.tester.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    Long bookId;

    @Column(name = "name")
    String name;

    @Column(name="author")
    String author;

    public Book(Long bookId, String name, String author) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
    }

    public Book(){}

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
