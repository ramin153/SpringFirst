package com.example.SpringFirst.bootStarp;

import com.example.SpringFirst.domain.Author;
import com.example.SpringFirst.domain.Book;
import com.example.SpringFirst.domain.Publisher;
import com.example.SpringFirst.repository.AuthorRepository;
import com.example.SpringFirst.repository.BookRepository;
import com.example.SpringFirst.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);



        Book toEnd = new Book("to the end of my life","11111111");
        Book why = new Book("there is no reason","11111112");








        Author emma = new Author("emma","burnwood");
        Author zelatan = new Author("zelatan","ibrahomovich");

        toEnd.getAuthors().add(emma);
        emma.getBooks().add(toEnd);
        toEnd.setPublisher(publisher);
        publisher.getBooks().add(toEnd);

        authorRepository.save(emma);
        bookRepository.save(toEnd);
        publisherRepository.save(publisher);



        why.getAuthors().add(zelatan);
        zelatan.getBooks().add(why);
        publisher.getBooks().add(why);
        why.setPublisher(publisher);

        authorRepository.save(zelatan);
        bookRepository.save(why);
        publisherRepository.save(publisher);















        System.out.println("number of book : "+bookRepository.count());
        System.out.println("number of book that publisher have : "+publisher.getBooks().size());

    }
}
