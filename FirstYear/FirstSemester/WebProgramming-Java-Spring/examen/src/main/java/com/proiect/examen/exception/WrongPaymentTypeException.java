package com.proiect.examen.exception;

public class WrongPaymentTypeException extends RuntimeException {
    public WrongPaymentTypeException() {
        super("The type must by \"ONLINE\" or \"POS\"");
    }
}
