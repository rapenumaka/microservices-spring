package com.mdk.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PhoneNumberNotFoundException extends RuntimeException{

    public PhoneNumberNotFoundException(String phoneNumber) {

        super(String.format("Card with phone-number %s not found", phoneNumber));
    }
}
