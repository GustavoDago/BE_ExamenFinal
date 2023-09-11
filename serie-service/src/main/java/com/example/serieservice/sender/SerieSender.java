package com.example.serieservice.sender;


import com.example.serieservice.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SerieSender {
    private final RabbitTemplate rabbitTemplate;
    private final Queue seriequeue;
    public void send(Serie serie){
        this.rabbitTemplate.convertAndSend(this.seriequeue.getName(),serie);
    }
}
