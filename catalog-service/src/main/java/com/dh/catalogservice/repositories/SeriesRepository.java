package com.dh.catalogservice.repositories;

import com.dh.catalogservice.domain.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends MongoRepository<Serie, String> {
}
