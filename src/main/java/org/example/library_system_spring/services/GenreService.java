package org.example.library_system_spring.services;

import org.example.library_system_spring.entities.Book;
import org.example.library_system_spring.entities.Genre;
import org.example.library_system_spring.repositories.BookRepository;
import org.example.library_system_spring.repositories.GenreRepository;
import org.example.library_system_spring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    public Genre findById(Long id){
        Optional<Genre> obj = genreRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }


}
