package com.mdk.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanNotFoundException extends RuntimeException {

    public LoanNotFoundException(String phoneNumber) {

        super(String.format("No Loan found with the  %s ", phoneNumber));
    }

}
