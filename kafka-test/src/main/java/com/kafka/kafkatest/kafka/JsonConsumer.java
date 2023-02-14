package com.kafka.kafkatest.kafka;

import com.kafka.kafkatest.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumer.class);

    @KafkaListener(topics = "TopicTest_Json", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Json Received -> %s", user.toString()));
    }
}
