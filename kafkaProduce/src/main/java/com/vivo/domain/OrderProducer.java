package com.vivo.domain;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
 
@Component
public class OrderProducer {
 
    @Value("test")
    private String orderTopic;
 
    private final KafkaTemplate kafkaTemplate;
 
    public OrderProducer(final KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
 
    public void send(final @RequestBody String order) {
        final String mensageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(orderTopic, mensageKey, order);
    }
}