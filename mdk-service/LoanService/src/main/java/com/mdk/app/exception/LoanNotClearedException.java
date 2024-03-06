package com.mdk.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanNotClearedException extends RuntimeException{

    public LoanNotClearedException (String phoneNumber) {

        super(String.format("Loan associated with %s is not cleared, so can't be deleted", phoneNumber));
    }
}
