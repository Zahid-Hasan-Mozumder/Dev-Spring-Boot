package com.zhm.spring_boot.rest.restcrud.rest;

public class studentNotFoundException extends RuntimeException{

    public studentNotFoundException(String message) {
        super(message);
    }

    public studentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public studentNotFoundException(Throwable cause) {
        super(cause);
    }
}
