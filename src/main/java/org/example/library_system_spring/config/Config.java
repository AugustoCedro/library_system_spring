package org.example.library_system_spring.config;

import org.example.library_system_spring.entities.*;
import org.example.library_system_spring.entities.enums.Status;
import org.example.library_system_spring.repositories.BookRepository;
import org.example.library_system_spring.repositories.ClientRepository;
import org.example.library_system_spring.repositories.GenreRepository;
import org.example.library_system_spring.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.*;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LoanRepository loanRepository;


    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        List<Book> bookList = CsvReader.bookReader();
        List<Genre> genreList = CsvReader.genreReader();
        List<Client> clientList = CsvReader.clientReader();

        bookRepository.saveAll(bookList);
        genreRepository.saveAll(genreList);
        clientRepository.saveAll(clientList);

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

        List<Loan> list= new ArrayList<>();
        for(int i = 0; i < 10 ; i++ ){
            int n = random.nextInt(2);
            Status status = null;
            if(n == 0){
                status = Status.ACTIVE;
            }else{
                status = Status.RETURNED;
            }
            Loan loan = new Loan(null, LocalDate.now(),status,clientList.getFirst(),bookList.getFirst());
            list.add(loan);
        }
        loanRepository.saveAll(list);





    }
}
