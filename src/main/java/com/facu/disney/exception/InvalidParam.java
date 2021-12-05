package com.facu.disney.exception;

public class InvalidParam extends RuntimeException {

    public InvalidParam(String error) {
        super(error);
    }
}
