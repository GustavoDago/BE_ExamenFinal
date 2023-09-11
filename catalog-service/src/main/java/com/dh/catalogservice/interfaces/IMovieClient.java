package com.dh.catalogservice.interfaces;

import com.dh.catalogservice.records.Movie;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "movie-service")
public interface IMovieClient {
    @CircuitBreaker(name = "movies",fallbackMethod = "findAllEmpty")
    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre);
    @CircuitBreaker(name = "movies",fallbackMethod = "findAllEmpty")
    @PostMapping("/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie);
    private List<Movie> findAllEmpty(CallNotPermittedException exception){
        return new ArrayList<>();
    }
}
