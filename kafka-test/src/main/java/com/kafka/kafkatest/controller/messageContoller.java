package com.kafka.kafkatest.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kafka.kafkatest.kafka.producer;
@RestController
@RequestMapping("/api/v1/kafka")

public class messageContoller {

    private producer producer;

   // you dont need to use @Autowired since it only has one parameterized constructor
    public messageContoller(producer producer){
        this.producer = producer;
    }
    //http://localhost:8080/api/v1/kafka/publish?message=xysz
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        producer.sendMessage(message); //uses the template we created
        return ResponseEntity.ok("Message sent to the topic");
    }

}
