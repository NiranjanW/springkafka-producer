package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestRunner implements CommandLineRunner {

    private final KafkaProducerService producerService;

    @Autowired
    public KafkaTestRunner(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @Override
    public void run(String... args) {
        // This will run when the application starts
        producerService.sendMessage("test_topic", "Hello Kafka!");
    }
}
