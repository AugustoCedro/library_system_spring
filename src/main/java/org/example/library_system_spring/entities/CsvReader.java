package org.example.library_system_spring.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Book> bookReader(){
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\projetos java\\library_system_spring\\books.csv"))){
            String line = br.readLine();
            List<Book> list = new ArrayList<>();
            while(line != null){
                String[] fields = line.split(",");

                Book book = new Book(null,fields[0],fields[1],fields[2],Double.parseDouble(fields[3]));
                list.add(book);
                line = br.readLine();
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
