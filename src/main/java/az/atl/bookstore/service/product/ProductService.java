package az.atl.bookstore.service.product;

import az.atl.bookstore.dto.ProductDto;
import az.atl.bookstore.entities.ProductEntity;
import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductEntity postProduct(Long categoryId, ProductDto productDto) throws IOException;
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto updateProduct(Long categoryId, Long productId, ProductDto productDto) throws IOException;
    void deleteProduct(Long id);
}
