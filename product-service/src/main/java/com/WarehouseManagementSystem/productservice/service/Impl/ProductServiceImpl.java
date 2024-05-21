package com.WarehouseManagementSystem.productservice.service.Impl;

import com.WarehouseManagementSystem.productservice.dto.ProductRequest;
import com.WarehouseManagementSystem.productservice.dto.ProductResponse;
import com.WarehouseManagementSystem.productservice.entity.Product;
import com.WarehouseManagementSystem.productservice.exception.ProductCreationException;
import com.WarehouseManagementSystem.productservice.exception.ProductRetrievalException;
import com.WarehouseManagementSystem.productservice.repository.ProductRepository;
import com.WarehouseManagementSystem.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {
        try {
            Product product = Product.builder()
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .build();

            productRepository.save(product);
            log.info("Product {} is saved", product.getId());
        } catch (Exception e) {
            log.error("Error occurred while creating product: {}", e.getMessage());
            throw new ProductCreationException("Error creating product", e);
        }
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();
            return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error occurred while retrieving products: {}", e.getMessage());
            throw new ProductRetrievalException("Error retrieving products", e);
        }
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
