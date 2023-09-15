package com.dh.catalogservice.service;

import com.dh.catalogservice.interfaces.IMovieClient;
import com.dh.catalogservice.records.Movie;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieClient{

    private final IMovieClient iMovieClient;

    public MovieService(IMovieClient iMovieClient) {
        this.iMovieClient = iMovieClient;
    }

    @CircuitBreaker(name = "movies",fallbackMethod = "findAllEmptyMovie")
    @Retry(name = "movies")
    @Override
    public ResponseEntity<Movie> save(Movie movie) {
        return iMovieClient.save(movie);
    }
    private List<Movie> findAllEmptyMovie(CallNotPermittedException exception){
        return new ArrayList<>();
    }
}
