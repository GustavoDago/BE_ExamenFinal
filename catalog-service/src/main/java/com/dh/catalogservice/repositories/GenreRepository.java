package com.dh.catalogservice.repositories;

import com.dh.catalogservice.domain.model.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GenreRepository extends MongoRepository<Genre,Genre> {

    List<Genre> findAll();
    List<Genre> findByGenre(String genre);
}
