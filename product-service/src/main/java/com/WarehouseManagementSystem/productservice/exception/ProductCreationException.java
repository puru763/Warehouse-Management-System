package com.WarehouseManagementSystem.productservice.exception;

public class ProductCreationException extends RuntimeException {
    public ProductCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}