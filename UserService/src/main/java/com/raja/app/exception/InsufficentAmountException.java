package com.raja.app.exception;

public class InsufficentAmountException extends RuntimeException{

    public InsufficentAmountException(String message){
        super(message);
    }
}
