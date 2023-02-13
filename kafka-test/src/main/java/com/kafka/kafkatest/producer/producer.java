package com.kafka.kafkatest.producer;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class producer {


    private static final Logger LOGGER = LoggerFactory.getLogger(producer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public producer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("TestTopic", message);
    }

}
