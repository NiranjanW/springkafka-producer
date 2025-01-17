package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my_topic", groupId = "my-group")
    public void listen(String message) {
        log.info("Received message: {}", message);
    }
}
