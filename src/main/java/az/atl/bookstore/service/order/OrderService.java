package az.atl.bookstore.service.order;

import az.atl.bookstore.dto.OrderDto;
import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
}
