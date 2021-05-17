package com.example.SpringFirst.repository;

import com.example.SpringFirst.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
