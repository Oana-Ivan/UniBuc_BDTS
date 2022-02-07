package com.proiect.examen.exception;

public class PaymentNotFound extends RuntimeException{
    public PaymentNotFound() {
        super("The payment does not exist");
    }
}
