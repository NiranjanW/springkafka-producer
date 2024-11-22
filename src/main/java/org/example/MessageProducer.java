package org.example;

import java.util.concurrent.CompletableFuture;

public interface MessageProducer {
    CompletableFuture<Boolean> sendMessage(String topic, String message);
}
