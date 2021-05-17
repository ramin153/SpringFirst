package com.example.SpringFirst.bootStarp;

import com.example.SpringFirst.domain.Author;
import com.example.SpringFirst.domain.Book;
import com.example.SpringFirst.repository.AuthorRepository;
import com.example.SpringFirst.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book toEnd = new Book("to the end of my life","11111111");
        Book why = new Book("there is no reason","11111112");

        Author emma = new Author("emma","burnwood");
        Author zelatan = new Author("zelatan","ibrahomovich");

        toEnd.getAuthors().add(emma);
        emma.getBooks().add(toEnd);


        why.getAuthors().add(zelatan);
        zelatan.getBooks().add(why);

        authorRepository.save(zelatan);
        authorRepository.save(emma);

        bookRepository.save(why);
        bookRepository.save(toEnd);



        System.out.println("number of book : "+bookRepository.count());

    }
}
