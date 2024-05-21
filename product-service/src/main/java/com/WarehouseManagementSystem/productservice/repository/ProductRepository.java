package com.WarehouseManagementSystem.productservice.repository;

import com.WarehouseManagementSystem.productservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}