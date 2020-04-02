package com.sample.exceptions;

public class InvalidBrandNameException extends IllegalArgumentException {
    public InvalidBrandNameException(String msg) {
        super(msg);
    }
}