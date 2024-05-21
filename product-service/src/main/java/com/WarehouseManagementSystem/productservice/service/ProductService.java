package com.WarehouseManagementSystem.productservice.service;

import com.WarehouseManagementSystem.productservice.dto.ProductRequest;
import com.WarehouseManagementSystem.productservice.dto.ProductResponse;
import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
}