package com.WarehouseManagementSystem.orderservice.service;

import com.WarehouseManagementSystem.orderservice.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
