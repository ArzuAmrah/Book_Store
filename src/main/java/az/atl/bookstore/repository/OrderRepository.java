package az.atl.bookstore.repository;

import az.atl.bookstore.entities.OrderEntity;
import az.atl.bookstore.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);

    List<OrderEntity> findAllByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);

    List<OrderEntity> findAllByOrderStatus(OrderStatus orderStatus);
}

