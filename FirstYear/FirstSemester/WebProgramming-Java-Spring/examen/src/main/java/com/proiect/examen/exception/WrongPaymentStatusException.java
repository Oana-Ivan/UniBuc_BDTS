package com.proiect.examen.exception;

public class WrongPaymentStatusException extends RuntimeException {
    public WrongPaymentStatusException() {
        super("The status must by \"NEW\" or \"PROCESSED\" or \"CANCELLED\"");
    }
}
