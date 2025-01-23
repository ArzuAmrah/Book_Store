package az.atl.bookshop.repository;

import az.atl.bookshop.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByCategoryName(String categoryName);

    List<ProductEntity> findByNameContaining(String name);
}
