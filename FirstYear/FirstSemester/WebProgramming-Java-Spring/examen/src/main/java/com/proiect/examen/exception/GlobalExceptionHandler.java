package com.proiect.examen.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    @ExceptionHandler({
            WrongPaymentTypeException.class,
            WrongPaymentStatusException.class,
            PaymentNotFound.class,
            PaymentAlreadyCancelledException.class,
            InvalidUpdateRequestException.class,
            PaymentAmountNegativeException.class
            })
    public ResponseEntity handle(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
