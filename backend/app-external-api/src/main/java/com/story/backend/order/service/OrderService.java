package com.story.backend.order.service;

import com.story.backend.address.service.AddressService;
import com.story.backend.order.dto.GenerateOrderRequest;
import com.story.backend.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final AddressService addressService;

    public OrderService(OrderRepository orderRepository, AddressService addressService) {
        this.orderRepository = orderRepository;
        this.addressService = addressService;
    }

    public UUID generateOrder(@Valid GenerateOrderRequest generateOrderRequest) {

        /*
        주소 생성
         */

        return orderRepository.save(generateOrderRequest.toEntity()).getOrderId();
    }
}
