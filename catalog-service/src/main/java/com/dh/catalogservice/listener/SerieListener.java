package com.dh.catalogservice.listener;

import com.dh.catalogservice.interfaces.IMovieClient;
import com.dh.catalogservice.interfaces.ISerieClient;
import com.dh.catalogservice.records.Movie;
import com.dh.catalogservice.records.Serie;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SerieListener {
    private final ISerieClient iSerieClient;

    public SerieListener(ISerieClient iSerieClient) {
        this.iSerieClient = iSerieClient;
    }

    @RabbitListener(queues = {"${queue.serie.ColaSerie"})
    public void receive(@Payload Serie serie){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        iSerieClient.create(serie);
    }
}
