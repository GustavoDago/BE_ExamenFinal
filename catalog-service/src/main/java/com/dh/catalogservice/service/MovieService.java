package com.dh.catalogservice.service;

import com.dh.catalogservice.interfaces.IMovieClient;
import com.dh.catalogservice.records.Movie;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@FeignClient(name = "movie-service")
@Service
@RequiredArgsConstructor
public class MovieService implements IMovieClient{
    private IMovieClient iMovieClient;
    @CircuitBreaker(name = "movies",fallbackMethod = "findAllEmptyMovie")
    @Override
    public ResponseEntity<Movie> save(Movie movie) {
        return iMovieClient.save(movie);
    }
    private List<Movie> findAllEmptyMovie(CallNotPermittedException exception){
        return new ArrayList<>();
    }
}
