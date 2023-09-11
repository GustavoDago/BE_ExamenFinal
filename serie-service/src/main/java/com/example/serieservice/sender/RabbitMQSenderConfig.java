package com.example.serieservice.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {
    @Value("${queue.serie.name}") //llave de configuración declarada en el application.yml
    private String serieQueue;

    @Bean
    public Queue queue() {
        return new Queue(this.serieQueue, true);
    }
}
