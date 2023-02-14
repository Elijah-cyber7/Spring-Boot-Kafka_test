package com.kafka.kafkatest.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(consumer.class);

    @KafkaListener(topics = "TestTopic", groupId= "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
