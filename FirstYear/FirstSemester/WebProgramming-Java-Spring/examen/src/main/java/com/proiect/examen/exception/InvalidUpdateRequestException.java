package com.proiect.examen.exception;

public class InvalidUpdateRequestException extends RuntimeException{
    public InvalidUpdateRequestException() {
        super("The id from the path must match the id from the body.");
    }
}
