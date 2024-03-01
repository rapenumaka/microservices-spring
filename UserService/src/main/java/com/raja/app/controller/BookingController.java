package com.raja.app.controller;

import com.raja.app.dto.BookingRequest;
import com.raja.app.dto.BookingStatus;
import com.raja.app.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@NoArgsConstructor
@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;



    @GetMapping("active")
    public ResponseEntity<String> isactive(){
        return ResponseEntity.ok("Active");
    }

    @PostMapping("book")
    public ResponseEntity<BookingStatus> createBooking(@RequestBody BookingRequest bookingRequest){

        BookingStatus bookingStatus = bookingService.bookTicket(bookingRequest);

        return new ResponseEntity<>(bookingStatus, HttpStatus.CREATED);
    }
}
