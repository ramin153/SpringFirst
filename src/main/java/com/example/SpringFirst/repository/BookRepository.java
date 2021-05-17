package com.example.SpringFirst.repository;

import com.example.SpringFirst.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
