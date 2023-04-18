package com.csi.controller;

import org.springframework.boot.autoconfigure.data.mongo.ReactiveStreamsMongoClientDependsOnBeanFactoryPostProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/orderdetailfallback")
    public ResponseEntity<String> OrderDetailFallBack(){

        return ResponseEntity.ok("OrderDetail Service is down Please Try Again !!!!!");
    }


    @GetMapping("/productfallback")
    public ResponseEntity<String> ProductFallBack(){

        return ResponseEntity.ok("Product Service is down Please Try Again !!!!!");
    }


    @GetMapping("/customerfallback")
    public ResponseEntity<String> CustomerFallBack(){

        return ResponseEntity.ok("Customer Service is down Please Try Again !!!!!");
    }
}
