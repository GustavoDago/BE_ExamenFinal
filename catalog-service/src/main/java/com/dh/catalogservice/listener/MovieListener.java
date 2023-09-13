package com.dh.catalogservice.listener;


import com.dh.catalogservice.records.Movie;
import com.dh.catalogservice.repositories.CatalogRepository;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {
    private final CatalogService catalogService;
    private CatalogRepository catalogRepository;

    public MovieListener(CatalogService catalogService){
        this.catalogService = catalogService;
    };

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receive(@Payload Movie movie){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        catalogService.guardarMovieEnCatalog(movie);
    }
}
