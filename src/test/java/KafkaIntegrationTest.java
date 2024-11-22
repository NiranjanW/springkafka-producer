import lombok.extern.slf4j.Slf4j;
import org.example.KafkaConsumerService;
import org.example.KafkaProducerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentCaptor.*;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.mock.mockito.SpyBean;



@SpringBootTest
public class KafkaIntegrationTest {

    @Autowired
    private KafkaProducerService producerService;

    @Autowired
    @SpyBean
    private KafkaConsumerService consumerService;


    private static final String TOPIC = "test_topic";
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(KafkaIntegrationTest.class);


    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testSendMessageNew() throws Exception {
//
//
//        // Given
//        String message = "Test message";
//        CountDownLatch latch = new CountDownLatch(1);
//        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);
//
//        doAnswer(invocation -> {
//            String receivedMessage = invocation.getArgument(0);
//            log.info("Received in test: {}", receivedMessage);
//            latch.countDown();
//            return null;
//         }).when(consumerService).listen(messageCaptor.capture());
//
//        // When
//        producerService.sendMessage(TOPIC, message)
//                .get(10, TimeUnit.SECONDS);
//
////        // Then
////        boolean messageReceived = latch.await(10, TimeUnit.SECONDS);
////        assertTrue(messageReceived, "Message should have been received");
////        assertEquals(message, messageCaptor.getValue());
////        verify(consumerService, timeout(5000)).listen(message);
//    }


    @Test
    void testSendMessage() throws Exception {
        final String TOPIC = "test_topic";
        // Given
        String message = "Test message";

        // When
        producerService.sendMessage(TOPIC, message)
                .get(10, TimeUnit.SECONDS); // Wait for completion

        // Then
//        ConsumerRecord<String, String> record = startConsumerTest(TOPIC); KafkaTestUtils.getSingleRecord(consumer, TOPIC);
//        assertNotNull(record);
//        assertEquals(message, record.value());
    }
}
//    private void startConsumerTest(String topic) {
//        String message = "Test message";
//        // Consumer test logic here
//        ConsumerRecords<String, String> records = consumerService.listen(message);// consume records
//        // Assert records received
//    }

