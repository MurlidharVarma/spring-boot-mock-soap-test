package com.lee.tester.controller;

import com.lee.tester.entity.Book;
import com.lee.tester.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return this.bookService.getAllBooks();
    }

//    @PostConstruct
//    public void run() throws Exception {
//        for(long i=1; i<=10; i++){
//            Book book = new Book(i,"Book Name "+i,"Author "+i);
//            bookService.saveBook(book);
//        }
//    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
