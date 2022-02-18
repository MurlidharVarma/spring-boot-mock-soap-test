package com.lee.tester;

import com.lee.tester.entity.Book;
import com.lee.tester.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesterApplication.class, args);
	}


}
