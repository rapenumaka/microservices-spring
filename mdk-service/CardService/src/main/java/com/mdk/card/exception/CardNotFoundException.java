package com.mdk.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException( String phoneNumber) {

        super(String.format("No Card found with the phone number %s ", phoneNumber));
    }
}
