package com.dh.catalogservice.listener;


import com.dh.catalogservice.domain.model.Genre;
import com.dh.catalogservice.interfaces.IMovieClient;
import com.dh.catalogservice.records.Movie;
import com.dh.catalogservice.repositories.GenreRepository;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {
    private final CatalogService catalogService;
    private GenreRepository genreRepository;

    public MovieListener(CatalogService catalogService){
        this.catalogService = catalogService;
    };

    @RabbitListener(queues = {"${queue.movie.ColaMovie"})
    public void receive(@Payload Movie movie){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
