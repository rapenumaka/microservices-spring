package com.mdk.app.exception;

import com.mdk.app.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice // Only handles exception occurring on Controller class
public class GlobalExceptionHandler {

    // WE CAN ALSO USE THIS METHOD TO FURTHER SEND EVENTS, OR FETcH DETAILS INTO DATABASE
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleAnyException(Exception exception,
                                                               WebRequest webRequest){
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleCardNotFoundException(LoanNotFoundException  exception,
                                                                                 WebRequest webRequest){
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoanNotClearedException.class)
    public ResponseEntity<ErrorResponseDto> handleCardNotFoundException(LoanNotClearedException  exception,
                                                                        WebRequest webRequest){
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoanWithPhoneNumberAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCardNotFoundException(LoanWithPhoneNumberAlreadyExistsException  exception,
                                                                        WebRequest webRequest){
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

}
