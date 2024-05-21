package com.WarehouseManagementSystem.orderservice.repository;

import com.WarehouseManagementSystem.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order ,Long> {
}
