package com.mdk.app.service;

import dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {



    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


    public void sendEventsToTopic(Customer customer){
        CompletableFuture<SendResult<String, Object>> completableFuture = this.kafkaTemplate.send("arvind75", customer);

        completableFuture.whenComplete((result,ex) ->{
            if(ex ==null){

                long offset = result.getRecordMetadata().offset();
                int partition = result.getRecordMetadata().partition();
                String email = customer.email();
                String outPutMessage = String.format(" Sent message %s with offset = [%s] and partion [%d]", email, String.valueOf(offset),partition );
                System.out.println(outPutMessage);
            }else{
                throw new  RuntimeException("Exception occured in Kafka");
            }
        });
    }

    public void messageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> completableFuture = this.kafkaTemplate.send("arvind88", message);

        completableFuture.whenComplete((result,ex) ->{
            if(ex ==null){

                long offset = result.getRecordMetadata().offset();
                int partition = result.getRecordMetadata().partition();
                String outPutMessage = String.format(" Sent message with [%s] with offset = [%s] and partion [%d]",message, String.valueOf(offset),partition );
                System.out.println(outPutMessage);
            }else{
                throw new  RuntimeException("Exception occured in Kafka");
            }
        });
    }
}
