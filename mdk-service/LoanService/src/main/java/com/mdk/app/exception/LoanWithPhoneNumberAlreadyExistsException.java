package com.mdk.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanWithPhoneNumberAlreadyExistsException extends RuntimeException{

    public LoanWithPhoneNumberAlreadyExistsException (String phoneNumber) {

        super(String.format("Loan already exists with phone-number %s", phoneNumber));
    }
}
