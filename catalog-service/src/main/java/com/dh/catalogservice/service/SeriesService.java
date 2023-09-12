package com.dh.catalogservice.service;

import com.dh.catalogservice.interfaces.ISerieClient;
import com.dh.catalogservice.records.Serie;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@FeignClient(name = "serie-service")
@RequiredArgsConstructor
public class SeriesService implements ISerieClient {
    private ISerieClient iSerieClient;
    @CircuitBreaker(name = "movies",fallbackMethod = "findAllEmptySeries")
    @Override
    public String create(Serie serie) {
        return iSerieClient.create(serie);
    }
    private List<Serie> findAllEmptySeries(CallNotPermittedException exception){
        return new ArrayList<>();
    }
}
