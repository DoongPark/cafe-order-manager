package com.dooongpark.cafeordermanager.controller;

import com.dooongpark.cafeordermanager.domain.Order;
import com.dooongpark.cafeordermanager.repository.OrderRepository;
import com.dooongpark.cafeordermanager.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @PostMapping("order")
    @ResponseBody
    public Order addOrder(@RequestParam String menu, @RequestParam Long pay) {
        Order order = new Order();
        order.setMenu(menu);
        order.setPay(pay);
        orderRepository.saveOrder(order);
        return order;
    }

    @PostMapping("order/cancel")
    @ResponseBody
    public String removeOrder(@RequestParam("ordernum") Long orderNum) {
        return orderService.removeOrder(orderNum);
    }

    @GetMapping("ordernum/{orderNum}")
    @ResponseBody
    public Order getOrderbyOrderNum(@PathVariable("orderNum") Long orderNum) {
        return orderRepository.findByOrderNum(orderNum).orElse(null);
    }
}
