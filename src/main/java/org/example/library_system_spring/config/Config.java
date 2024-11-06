package org.example.library_system_spring.config;

import org.example.library_system_spring.entities.Book;
import org.example.library_system_spring.entities.CsvReader;
import org.example.library_system_spring.entities.Genre;
import org.example.library_system_spring.repositories.BookRepository;
import org.example.library_system_spring.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Book> bookList = CsvReader.bookReader();
        List<Genre> genreList = CsvReader.genreReader();


        bookRepository.saveAll(bookList);
        genreRepository.saveAll(genreList);

        List<Genre> allGenres = genreRepository.findAll();


        Map<String, String[]> bookMap = CsvReader.bookGenreReader();


        for (Book book : bookList) {
           String[] bookGenres = bookMap.get(book.getTitle());
           for(String bookGenre : bookGenres){
               for(Genre genre : allGenres){
                   if(Objects.equals(genre.getName(), bookGenre)){
                       book.getGenreList().add(genre);
                   }
               }
           }
           bookRepository.save(book);
        }
    }
}
