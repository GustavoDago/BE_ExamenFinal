package com.dh.catalogservice.interfaces;

import com.dh.catalogservice.records.Serie;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "serie-service")
public interface ISerieClient {
    @CircuitBreaker(name = "movies",fallbackMethod = "findAllEmpty")
    @GetMapping
    public List<Serie> getAll();
    @CircuitBreaker(name = "movies",fallbackMethod = "findAllEmpty")
    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre);
    @CircuitBreaker(name = "movies",fallbackMethod = "findAllEmpty")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Serie serie);
    private List<Serie> findAllEmpty(CallNotPermittedException exception){
        return new ArrayList<>();
    }
}
