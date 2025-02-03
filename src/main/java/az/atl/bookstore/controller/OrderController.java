package az.atl.bookstore.controller;

import az.atl.bookstore.dto.OrderDto;
import az.atl.bookstore.dto.PlaceOrderDto;
import az.atl.bookstore.service.customer.CustomerService;
import az.atl.bookstore.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;

    // Admin üçün bütün sifarişlərin əldə edilməsi
    @GetMapping("/admin")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtoList = orderService.getAllOrders();
        return ResponseEntity.ok(orderDtoList);
    }

    // Müştəri üçün sifariş yerləşdirmə
    @PostMapping("/customer/placeOrder")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody PlaceOrderDto placeOrderDto) {
        OrderDto orderDto = customerService.placeOrder(placeOrderDto);
        if (orderDto == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }

    // Müştəri üçün istifadəçi ID-sinə görə sifarişləri əldə etmə
    @GetMapping("/customer/{userId}")
    public ResponseEntity<List<OrderDto>> getOrderByUserId(@PathVariable Long userId) {
        List<OrderDto> orderDtoList = customerService.getOrderByUserId(userId);
        return ResponseEntity.ok(orderDtoList);
    }
}
