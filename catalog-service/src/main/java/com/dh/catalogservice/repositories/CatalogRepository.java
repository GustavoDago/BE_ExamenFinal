package com.dh.catalogservice.repositories;

import com.dh.catalogservice.domain.model.Catalogo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogRepository extends MongoRepository<Catalogo, String> {
    Optional<Catalogo> findByGenreOptional(String genre);
    Catalogo findByGenre(String genre);

}
