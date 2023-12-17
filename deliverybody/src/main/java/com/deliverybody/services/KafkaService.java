package com.deliverybody.services;

import com.deliverybody.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {


    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    //helps to send message
    public boolean updateLocation(String location){

    this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
        logger.info("message produced");
        logger.info("_-_-_-_-_-_-_-_-_-_-");


        return true;
    }
}
