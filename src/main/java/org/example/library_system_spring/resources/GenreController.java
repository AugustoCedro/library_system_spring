package org.example.library_system_spring.resources;

import org.example.library_system_spring.entities.Book;
import org.example.library_system_spring.entities.Genre;
import org.example.library_system_spring.services.BookService;
import org.example.library_system_spring.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<Genre> getAllBooks() {
        return genreService.findAllGenres();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Genre> getById(@PathVariable Long id){
        Genre genre = genreService.findById(id);
        return ResponseEntity.ok().body(genre);
    }



}
