package az.atl.bookshop.controller;

import az.atl.bookshop.entities.OrderEntity;
import az.atl.bookshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {

    private OrderService orderService;

    @PostMapping("/place")
    public OrderEntity placeOrder(@RequestParam Long userId, @RequestParam String deliveryAddress) {
        return orderService.placeOrder(userId, deliveryAddress);
    }

    @GetMapping("/{userId}")
    public List<OrderEntity> getUserOrders(@PathVariable Long userId) {
        return orderService.getUserOrders(userId);
    }
}
