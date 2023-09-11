package com.dh.catalogservice.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
@RequiredArgsConstructor
public class Serie {
    @MongoId
    private Long id;
    private String name;
    private String genre;
}
