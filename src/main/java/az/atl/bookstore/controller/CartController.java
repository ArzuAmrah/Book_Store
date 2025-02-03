package az.atl.bookstore.controller;

import az.atl.bookstore.dto.CartItemDto;
import az.atl.bookstore.dto.OrderDto;
import az.atl.bookstore.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer/cart")
public class CartController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> postProductToCart(@RequestBody CartItemDto cartItemDto) {
        return customerService.addProducttoCart(cartItemDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<OrderDto> getCartByUserId(@PathVariable Long userId) {
        OrderDto orderDto = customerService.getCartByUserId(userId);
        if (orderDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("/{userId}/deduct/{productId}")
    public ResponseEntity<OrderDto> addMinusOnProduct(@PathVariable Long userId, @PathVariable Long productId) {
        OrderDto orderDto = customerService.addMinusOnProduct(userId, productId);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("/{userId}/add/{productId}")
    public ResponseEntity<OrderDto> addPlusOnProduct(@PathVariable Long userId, @PathVariable Long productId) {
        OrderDto orderDto = customerService.addPlusOnProduct(userId, productId);
        return ResponseEntity.ok(orderDto);
    }
}

