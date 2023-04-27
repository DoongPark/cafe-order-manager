package com.dooongpark.cafeordermanager.service;

import com.dooongpark.cafeordermanager.domain.Order;
import com.dooongpark.cafeordermanager.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Long placeOrder(Order order) {
        orderRepository.saveOrder(order);
        return order.getOrderNum();
    }

    @Override
    public String removeOrder(Long orderNum) {
        Optional<Order> opt = orderRepository.findByOrderNum(orderNum);
        if (!opt.isPresent()) {
            throw new IllegalStateException("존재하지 않는 주문번호입니다.");
        }
        orderRepository.removeOrder(orderNum);
        return orderNum+"번 주문이 성공적으로 취소되었습니다.";
    }

}
