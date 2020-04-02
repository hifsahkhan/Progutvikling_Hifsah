package com.sample.exceptions;

public class InvalidPartNumberException extends IllegalArgumentException {
    public InvalidPartNumberException(String msg) {
        super(msg);
    }
}