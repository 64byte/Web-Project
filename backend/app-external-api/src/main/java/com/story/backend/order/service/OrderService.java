package com.story.backend.order.service;

import com.story.backend.order.dto.GenerateOrderRequest;
import com.story.backend.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public UUID generateOrder(@Valid GenerateOrderRequest generateOrderRequest) {
        return orderRepository.save(generateOrderRequest.toEntity()).getOrderId();
    }
}
