package org.example;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//public class KafkaProducerService {
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    public void sendMessage(String topic, String message) {
////
//
//
//        kafkaTemplate.send(topic, message)
//                .thenAccept(result -> log.info("Message sent successfully to topic: {}", topic))
//                .exceptionally(ex -> {
//                    log.error("Failed to send message to topic: {}", topic, ex);
//                    return null;
//                });
//    }
//}
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;


@Slf4j
@Service
public class KafkaProducerService implements MessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public CompletableFuture<Boolean> sendMessage(String topic, String message) {
        return kafkaTemplate.send(topic, message)
                .thenApply(sendResult -> {
                    log.info("Message sent successfully to topic: {}, partition: {}, offset: {}",
                            topic,
                            sendResult.getRecordMetadata().partition(),
                            sendResult.getRecordMetadata().offset());
                    return true;
                })
                .exceptionally(ex -> {
                    log.error("Failed to send message to topic: {}", topic, ex);
                    return false;
                });
    }
}