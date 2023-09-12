package com.dh.catalogservice.repositories;

import com.dh.catalogservice.domain.model.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GenreRepository extends MongoRepository<Genre,Genre> {
    List<Genre> findByGenre(String genre);

}
