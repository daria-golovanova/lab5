package com.golovanova.exceptions;

public class IllegalMessageException extends Exception {
    public IllegalMessageException(String message) {
        super(message);
    }

    public IllegalMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
