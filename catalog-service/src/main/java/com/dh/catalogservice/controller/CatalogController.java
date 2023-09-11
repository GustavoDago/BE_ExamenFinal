package com.dh.catalogservice.controller;

import com.dh.catalogservice.domain.model.Genre;
import com.dh.catalogservice.interfaces.IMovieClient;
import com.dh.catalogservice.listener.MovieListener;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private IMovieClient iMovieClient;
    private MovieListener movieListener;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }
    @GetMapping("/{genre}")
    public ResponseEntity<List<Genre>> getCatalogByGenre(@PathVariable String genre){
        return ResponseEntity.ok(catalogService.buscarPorGenero(genre));
    }
    @PostMapping("/guardar")
    public ResponseEntity<Genre> guardarGenre(@RequestBody Genre genre){
        movieListener.receive(genre);
        return ResponseEntity.noContent().build();
    }
}
