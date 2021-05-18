package com.example.SpringFirst.repository;

import com.example.SpringFirst.domain.Publisher;
import org.springframework.data.repository.CrudRepository;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}