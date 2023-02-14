package com.kafka.kafkatest.controller;

import com.kafka.kafkatest.kafka.JsonProducer;
import com.kafka.kafkatest.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonProducer producer;

    public JsonMessageController(JsonProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        producer.sendMessage(user);
        return ResponseEntity.ok("Message Posted to kafka topic");
    }
}
