package az.atl.bookstore.service.customer;

import az.atl.bookstore.dto.CartItemDto;
import az.atl.bookstore.dto.OrderDto;
import az.atl.bookstore.dto.PlaceOrderDto;
import az.atl.bookstore.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    List<ProductDto> getAllProducts();

    List<ProductDto> getProductsByTitle(String title);

    ResponseEntity<?> addProducttoCart(CartItemDto cartItemDto);

    OrderDto getCartByUserId(Long userId);

    OrderDto addMinusOnProduct(Long userId, Long productId);

    OrderDto addPlusOnProduct(Long userId, Long productId);

    OrderDto placeOrder(PlaceOrderDto placeOrderDto);

    List<OrderDto>getOrderByUserId(Long userId);

}
