package com.WarehouseManagementSystem.orderservice.service.Impl;

import com.WarehouseManagementSystem.orderservice.dto.OrderLineItemsDto;
import com.WarehouseManagementSystem.orderservice.dto.OrderRequest;
import com.WarehouseManagementSystem.orderservice.entity.Order;
import com.WarehouseManagementSystem.orderservice.entity.OrderLineItems;
import com.WarehouseManagementSystem.orderservice.exception.OrderPlacementException;
import com.WarehouseManagementSystem.orderservice.repository.OrderRepository;
import com.WarehouseManagementSystem.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void placeOrder(OrderRequest orderRequest) throws OrderPlacementException {
        try {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());

            List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                    .stream()
                    .map(orderLineItemsDto -> mapToDto(orderLineItemsDto, order))
                    .toList();

            order.setOrderLineItemsList(orderLineItems);
            orderRepository.save(order);
        } catch (Exception e) {
            throw new OrderPlacementException("Failed to place order", e);
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto, Order order) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setOrder(order);
        return orderLineItems;
    }
}
