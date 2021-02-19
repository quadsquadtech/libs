package com.ttmdaniel.core.exception;


public class AbstractValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private AbstractValidationException(String message) {
        super(message);
    }

    private AbstractValidationException(Throwable cause) {
        super(cause);
    }

    private AbstractValidationException(String message, Throwable cause) {
        super(message, cause);
    }


    public static AbstractValidationException of(String message) {
        return new AbstractValidationException(message);
    }
    public static AbstractValidationException of(Throwable cause) {
        return new AbstractValidationException(cause);
    }

    public static AbstractValidationException of(String message, Throwable cause) {
        return new AbstractValidationException(message, cause);
    }

}
