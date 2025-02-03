package az.atl.bookstore.service.order;

import az.atl.bookstore.dto.OrderDto;
import az.atl.bookstore.entities.OrderEntity;
import az.atl.bookstore.enums.OrderStatus;
import az.atl.bookstore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAllByOrderStatus(OrderStatus.SUBMITTED).stream()
                .map(OrderEntity::getOrderDto)
                .collect(Collectors.toList());
    }
}

