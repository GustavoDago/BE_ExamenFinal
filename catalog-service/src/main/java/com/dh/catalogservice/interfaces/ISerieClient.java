package com.dh.catalogservice.interfaces;

import com.dh.catalogservice.records.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "serie-service")
public interface ISerieClient {
    @PostMapping("/api/v1/serie")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Serie> create(@RequestBody Serie serie);
}
