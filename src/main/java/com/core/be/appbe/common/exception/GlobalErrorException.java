package com.core.be.appbe.common.exception;

public class GlobalErrorException extends RuntimeException {

    public GlobalErrorException(String message){
        super(message);
    }

    public GlobalErrorException(String message, Throwable throwable){
        super(message, throwable);
    }
}
