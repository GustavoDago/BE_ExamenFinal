package com.dh.catalogservice.controller;

import com.dh.catalogservice.domain.model.Catalogo;
import com.dh.catalogservice.interfaces.IMovieClient;
import com.dh.catalogservice.interfaces.ISerieClient;
import com.dh.catalogservice.listener.MovieListener;
import com.dh.catalogservice.listener.SerieListener;
import com.dh.catalogservice.records.Movie;
import com.dh.catalogservice.records.Serie;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private IMovieClient iMovieClient;
    @Autowired
    private ISerieClient iSerieClient;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public ResponseEntity<List<Catalogo>> listarTodos(){
        return ResponseEntity.ok(catalogService.listarTodos());
    }
    @GetMapping("/{genre}")
    public ResponseEntity<Optional<Catalogo>> getCatalogByGenre(@PathVariable String genre){
        return ResponseEntity.ok(catalogService.buscarPorGenero(genre));
    }
    @PostMapping("/guardar")
    public ResponseEntity<Catalogo> guardarGenre(@RequestBody Catalogo catalogo){
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/movie")
    public ResponseEntity<Movie> guardarMovie(@RequestBody Movie movie){
        return iMovieClient.save(movie);
    }
    @PostMapping("/serie")
    public ResponseEntity<Serie> guardarSerie(@RequestBody Serie serie){
        return iSerieClient.create(serie);
    }
}
