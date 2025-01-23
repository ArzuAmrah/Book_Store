package az.atl.bookshop.service;

import az.atl.bookshop.entities.BasketEntity;
import az.atl.bookshop.entities.OrderEntity;
import az.atl.bookshop.entities.UserEntity;
import az.atl.bookshop.repository.BasketRepository;
import az.atl.bookshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final BasketRepository basketRepository;
    private final OrderRepository orderRepository;

    public List<OrderEntity> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public OrderEntity placeOrder(Long userId, String deliveryAddress) {

        List<BasketEntity> basketItems = basketRepository.findByUserId(userId);

        double totalAmount = basketItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        OrderEntity order = new OrderEntity();
        UserEntity user = new UserEntity();
        user.setId(userId);
        order.setUser(user);
        order.setDeliveryAddress(deliveryAddress);
        order.setOrderDate(new Date());
        order.setTotalAmount(totalAmount);

        basketRepository.deleteAll(basketItems);

        return orderRepository.save(order);
    }
}
