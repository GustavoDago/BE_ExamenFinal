package com.dh.catalogservice.interfaces;

import com.dh.catalogservice.records.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@FeignClient(name = "movie-service")
public interface IMovieClient {
    @PostMapping("/api/v1/movies/save")
    ResponseEntity<Movie> save(@RequestBody Movie movie);
}
