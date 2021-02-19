package com.ttmdaniel.core.exception;


public class AbstractServiceRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private AbstractServiceRuntimeException(String message) {
        super(message);
    }

    private AbstractServiceRuntimeException(Throwable cause) {
        super(cause);
    }

    private AbstractServiceRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }


    public static AbstractServiceRuntimeException of(String message) {
        return new AbstractServiceRuntimeException(message);
    }
    public static AbstractServiceRuntimeException of(Throwable cause) {
        return new AbstractServiceRuntimeException(cause);
    }

    public static AbstractServiceRuntimeException of(String message, Throwable cause) {
        return new AbstractServiceRuntimeException(message, cause);
    }
}
