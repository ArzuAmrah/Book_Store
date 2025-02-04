package az.atl.bookstore.repository;

import az.atl.bookstore.entities.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<WishlistEntity, Long> {

    List<WishlistEntity> findByUserId(Long userId);
}
