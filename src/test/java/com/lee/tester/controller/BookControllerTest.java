package com.lee.tester.controller;

import com.lee.tester.entity.Book;
import com.lee.tester.repo.BookRepository;
import com.lee.tester.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
class BookControllerTest {

    MockMvc mockMvc;

    @Mock
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookController bookController;

    @BeforeEach
    public void initTest(){
        MockitoAnnotations.initMocks(this);
        this.bookService.setBookRepository(bookRepository);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    @DisplayName("Get all books")
    public void test1(){
        Mockito.when(bookService.getAllBooks()).thenReturn(Stream.of(new Book(1L,"Test Book", "Test Author")).collect(Collectors.toList()));

        List<Book> books = bookController.getAllBooks();
        assertEquals(1, books.size());
    }
}
