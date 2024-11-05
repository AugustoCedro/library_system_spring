package org.example.library_system_spring.config;

import org.example.library_system_spring.entities.Book;
import org.example.library_system_spring.entities.CsvReader;
import org.example.library_system_spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public void run(String... args) throws Exception {

        List<Book> bookList = CsvReader.bookReader();

        bookRepository.saveAll(bookList);


    }
}
