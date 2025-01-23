package az.atl.bookshop.repository;

import az.atl.bookshop.entities.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, Long> {

    List<BasketEntity> findByUserId(Long userId);
}

