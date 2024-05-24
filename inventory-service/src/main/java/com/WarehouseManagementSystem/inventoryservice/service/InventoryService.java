package com.WarehouseManagementSystem.inventoryservice.service;

import com.WarehouseManagementSystem.inventoryservice.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);
}
