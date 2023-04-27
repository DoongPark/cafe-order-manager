package com.dooongpark.cafeordermanager.repository;

import com.dooongpark.cafeordermanager.domain.Order;

import java.util.Optional;

public interface OrderRepository {
    Order saveOrder(Order order);
    void removeOrder(Long orderNum);
    Optional<Order> findByOrderNum(Long orderNum);
}
