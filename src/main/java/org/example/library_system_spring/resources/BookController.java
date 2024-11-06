package org.example.library_system_spring.resources;

import org.example.library_system_spring.entities.Book;

import org.example.library_system_spring.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
        Book book = bookService.findById(id);
        return ResponseEntity.ok().body(book);
    }



}
