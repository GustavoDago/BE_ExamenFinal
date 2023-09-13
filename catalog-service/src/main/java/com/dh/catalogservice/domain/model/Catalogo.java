package com.dh.catalogservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
public class Catalogo {
    private String genre;
    private List<Movie> movies;
    private List<Serie> series;

    public Catalogo() {

    }
}
