package org.example.library_system_spring.entities;

import org.example.library_system_spring.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvReader {


    public static List<Book> bookReader(){
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\projetos java\\library_system_spring\\CSVs\\books.csv"))){
            String line = br.readLine();
            List<Book> list = new ArrayList<>();
            while(line != null){
                String[] fields = line.split(",");
                Book book = new Book(null,fields[0],fields[1],fields[2],Double.parseDouble(fields[3]),10);
                list.add(book);
                line = br.readLine();
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Genre> genreReader(){
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\projetos java\\library_system_spring\\CSVs\\genres.csv"))){
            String line = br.readLine();
            List<Genre> list = new ArrayList<>();
            while(line != null){
                Genre genre = new Genre(null,line);
                list.add(genre);
                line = br.readLine();
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<String,String[]> bookGenreReader(){
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\projetos java\\library_system_spring\\CSVs\\books.csv"))){
            String line = br.readLine();
            Map<String,String[]> bookMap = new HashMap<>();
            while(line != null){
                String[] fields = line.split(",");
                String[] genres = fields[4].split(" ");
                bookMap.put(fields[0],genres);
                line = br.readLine();
            }
            return bookMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
