package org.example.library_system_spring.services;

import org.example.library_system_spring.entities.Book;
import org.example.library_system_spring.repositories.BookRepository;
import org.example.library_system_spring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findById(Long id){
        Optional<Book> obj = bookRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }


}
