package com.epam.training.microservices.taxicustomerservice.exceptions;

public class CustomerNotFoundNotException extends RuntimeException {

    public CustomerNotFoundNotException(String customerUsername) { super("Customer " + customerUsername + " not found"); }
    public CustomerNotFoundNotException() {}
}
