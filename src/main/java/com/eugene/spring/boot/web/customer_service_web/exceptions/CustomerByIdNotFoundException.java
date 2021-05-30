package com.eugene.spring.boot.web.customer_service_web.exceptions;

public class CustomerByIdNotFoundException extends RuntimeException{
    public CustomerByIdNotFoundException(String message) {
        super(message);
    }
}
