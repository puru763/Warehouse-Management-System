package com.WarehouseManagementSystem.orderservice.exception;

public class OrderPlacementException extends RuntimeException {
    public OrderPlacementException(String message) {
        super(message);
    }

    public OrderPlacementException(String message, Throwable cause) {
        super(message, cause);
    }
}
