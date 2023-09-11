package com.dh.catalogservice.service;

import com.dh.catalogservice.domain.model.Genre;
import com.dh.catalogservice.repositories.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {
    public final GenreRepository genreRepository;

    public List<Genre> buscarTodos(){
        return genreRepository.findAll();
    }
    public List<Genre> buscarPorGenero(String genero){
        return genreRepository.findByGenre(genero);
    }
    public Genre guardarGenre(Genre genre){
        return genreRepository.insert(genre);
    }
}
