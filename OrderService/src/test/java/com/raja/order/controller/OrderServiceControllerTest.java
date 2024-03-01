package com.raja.order.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderServiceController.class)
class OrderServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_sayHello() throws Exception {
       mockMvc.perform(get("/api/v1/hello/abhinay")).andExpect(status().isOk());
    }

}