package az.atl.bookshop.service;

import az.atl.bookshop.entities.ProductEntity;
import az.atl.bookshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductEntity> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    public List<ProductEntity> searchProducts(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }
}
