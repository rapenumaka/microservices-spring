package com.mdk.app.service;

import com.mdk.app.dao.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListerner {
    Logger logger = LoggerFactory.getLogger(KafkaMessageListerner.class);


/*    @KafkaListener(topics = "arvind88", groupId = "consumer-group-1")
    public void consumeMessage(String message){


        logger.info("Consumer consumes the message {}", message );
    }*/

    @KafkaListener(topics = "arvind55", groupId = "consumer-group-1")
    public void consumeCustomer(Customer customer){

        logger.info("Consumer-1 consumes the customer {}", customer.toString() );
    }
}
