package com.dh.catalogservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@AllArgsConstructor
public class Catalogo {
    @Id
    private String id;
    private String genre;
    private List<Movie> movies = new ArrayList<>();
    private List<Serie> series = new ArrayList<>();

    public Catalogo() {

    }
}
