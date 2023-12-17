package com.deliverybody.controllers;

import com.deliverybody.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;


    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        for (int i = 0; i<=1000001; i++) {
            String loc = "( " + Math.round(Math.random() * 100) + ",  " + Math.round(Math.random() * 100) + " )";
            kafkaService.updateLocation(loc);

        }
        return new ResponseEntity<>(Map.of("message","location updated"), HttpStatus.OK);
    }
}
