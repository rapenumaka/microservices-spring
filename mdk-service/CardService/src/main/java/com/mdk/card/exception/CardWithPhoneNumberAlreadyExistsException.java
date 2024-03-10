package com.mdk.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardWithPhoneNumberAlreadyExistsException extends RuntimeException{

    public CardWithPhoneNumberAlreadyExistsException(String phoneNumber) {

        super(String.format("Card already exists with phone-number %s", phoneNumber));
    }
}
