package com.proiect.examen.exception;

public class PaymentAmountNegativeException extends RuntimeException {
    public PaymentAmountNegativeException() {
        super("Payment amount must not be negative");
    }
}
