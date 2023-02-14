package com.kafka.kafkatest.kafka;


import com.kafka.kafkatest.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);

    private KafkaTemplate<String, User> template;

    public JsonProducer(KafkaTemplate<String, User> template) {
        this.template = template;
    }

    public void sendMessage(User data){

        LOGGER.info(String.format("JSON payload sent -> %s", data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "TestTopic_Json")
                .build();

        template.send(message);
    }
}
