package com.dh.catalogservice.service;

import com.dh.catalogservice.domain.model.Catalogo;
import com.dh.catalogservice.records.Movie;
import com.dh.catalogservice.records.Serie;
import com.dh.catalogservice.repositories.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CatalogService {
    private CatalogRepository catalogRepository;
    public Catalogo buscarPorGenero(String genre) {
        return catalogRepository.findByGenre(genre);
    }
    public Catalogo guardarMovieEnCatalog(Movie movie){
        Catalogo catalogo = new Catalogo();
        Optional<Catalogo> optionalCatalogo = catalogRepository.findByGenreOptional(movie.genre());
        if (optionalCatalogo.isPresent()){
            catalogo = optionalCatalogo.get();
        }
        else {
            catalogo.setGenre(movie.genre());
        }
        List<com.dh.catalogservice.domain.model.Movie> movieList = catalogo.getMovies();
        movieList.add(convertirRecordToMovie(movie));
        catalogo.setMovies(movieList);
        return catalogRepository.insert(catalogo);
    }
    public Catalogo guardarSerieEnCatalog(Serie serie) {
        Catalogo catalogo = new Catalogo();
        List<com.dh.catalogservice.domain.model.Serie> serieList = new ArrayList<>();
        Optional<Catalogo> optionalCatalogo = catalogRepository.findByGenreOptional(serie.genre());
        if (optionalCatalogo.isPresent()){
            catalogo = optionalCatalogo.get();
            serieList = catalogo.getSeries();
        }
        else {
            catalogo.setGenre(serie.genre());
        }
        serieList.add(convertirRecordToSerie(serie));
        catalogo.setSeries(serieList);
        return catalogRepository.insert(catalogo);
    }

    private com.dh.catalogservice.domain.model.Serie convertirRecordToSerie(Serie serie) {
        com.dh.catalogservice.domain.model.Serie serieMongo = new com.dh.catalogservice.domain.model.Serie();
        serieMongo.setId(serie.id());
        serieMongo.setName(serie.name());
        serieMongo.setGenre(serie.genre());
        return serieMongo;
    }

    private com.dh.catalogservice.domain.model.Movie convertirRecordToMovie(Movie movieRecord) {
            com.dh.catalogservice.domain.model.Movie movieMongo = new com.dh.catalogservice.domain.model.Movie();
            movieMongo.setId(movieRecord.id());
            movieMongo.setName(movieRecord.name());
            movieMongo.setGenre(movieRecord.genre());
            movieMongo.setUrlStream(movieRecord.urlStream());
            return movieMongo;
    }
}
