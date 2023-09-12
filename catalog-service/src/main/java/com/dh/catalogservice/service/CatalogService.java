package com.dh.catalogservice.service;

import com.dh.catalogservice.domain.model.Genre;
import com.dh.catalogservice.interfaces.IMovieClient;
import com.dh.catalogservice.interfaces.ISerieClient;
import com.dh.catalogservice.records.Movie;
import com.dh.catalogservice.records.Serie;
import com.dh.catalogservice.repositories.GenreRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CatalogService {
    private GenreRepository genreRepository;
    public List<Genre> buscarPorGenero(String genre) {
        return genreRepository.findByGenre(genre);
    }

}
