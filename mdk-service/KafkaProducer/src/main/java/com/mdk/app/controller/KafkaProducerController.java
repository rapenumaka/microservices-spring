package com.mdk.app.controller;

import com.mdk.app.service.KafkaMessagePublisher;
import dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class KafkaProducerController {

    //kafka-topics.sh --bootstrap-server localhost:9092 --create --topic arvind65   --partitions 3 --replication-factor 1
    //kafka-topics.sh --bootstrap-server localhost:9092 --create --topic arvind77 --partitions 3 --replication-factor 1   /* Create a topic with partion=3*/


    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @PostMapping("/produce")
    public ResponseEntity<String> publish(@RequestParam String value){

        for(int i =0; i < 100000; i++){
            this.kafkaMessagePublisher.messageToTopic(value);
        }


        return ResponseEntity.ok("Success");
    }

    @PostMapping("/sendCustomer")
    public ResponseEntity<String> publish(@RequestBody Customer customer){


            this.kafkaMessagePublisher.sendEventsToTopic(customer);



        return ResponseEntity.ok("Success");
    }
}
