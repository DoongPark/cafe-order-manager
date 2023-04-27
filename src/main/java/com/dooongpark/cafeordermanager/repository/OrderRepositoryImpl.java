package com.dooongpark.cafeordermanager.repository;

import com.dooongpark.cafeordermanager.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static Map<Long, Order> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Order saveOrder(Order order) {
        order.setOrderNum(++sequence);
        store.put(order.getOrderNum(), order);
        return order;
    }

    @Override
    public void removeOrder(Long orderNum) { // 완료된 주문이므로 store에서 삭제하긴 했지만 접수번호 url로 들어갔을때 완료라고 뜨게 하고 싶으면?
        store.remove(orderNum);
    }

    @Override
    public Optional<Order> findByOrderNum(Long orderNum) {
        return Optional.ofNullable(store.get(orderNum));
    }
}
