package com.vivo.controller;

import com.vivo.domain.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api")
public class OrderController {
 
    private final OrderProducer orderProducer;
 
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }
 
    @PostMapping("/produto")
    public void send(@RequestBody String order) {
        orderProducer.send(order);
    }
    

}

