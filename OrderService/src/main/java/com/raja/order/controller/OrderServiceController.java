package com.raja.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/")
@RestController
@Slf4j
public class OrderServiceController {

    @GetMapping("hello/{name}")
    public ResponseEntity<String> sayHello(@PathVariable("name") String name){
        log.info("value of name "+name);

        String result = String.format("Hello",name);
        System.out.println(result+name);
        return new ResponseEntity<>(result+name, HttpStatus.OK);
    }

}
