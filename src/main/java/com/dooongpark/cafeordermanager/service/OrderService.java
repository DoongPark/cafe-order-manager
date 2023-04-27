package com.dooongpark.cafeordermanager.service;

import com.dooongpark.cafeordermanager.domain.Order;

public interface OrderService {
    Long placeOrder(Order order);
    String removeOrder(Long order);
}
