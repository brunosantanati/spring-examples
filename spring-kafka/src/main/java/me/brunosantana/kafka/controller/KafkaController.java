package me.brunosantana.kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.brunosantana.kafka.model.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Value("${kafka.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, MyMessage> kafkaTemplate;

    @GetMapping("message/{msg}")
    public String postMessage(@PathVariable String msg){
        kafkaTemplate.send(topicName, new MyMessage(msg, msg));
        return "message posted in Kafka topic!";
    }

    @GetMapping("json")
    public String postJsonMessage() throws JsonProcessingException {
        MyMessage myMessage = new MyMessage("campo 1", "campo 2");
        //String msg = new ObjectMapper().writeValueAsString(myMessage);
        kafkaTemplate.send(topicName, myMessage);
        return "message posted in Kafka topic!";
    }
}
