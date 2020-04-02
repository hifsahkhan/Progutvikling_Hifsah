package com.sample.exceptions;

public class InvalidPriceException extends IllegalArgumentException {
    public InvalidPriceException(String msg) {
        super(msg);
    }
}