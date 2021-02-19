package com.quadsquad.core;


public class IServiceRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IServiceRuntimeException(String message) {
        super(message);
    }

    public IServiceRuntimeException(Throwable cause) {
        super(cause);
    }

    public IServiceRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
