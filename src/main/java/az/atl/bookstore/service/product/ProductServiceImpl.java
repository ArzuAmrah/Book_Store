package az.atl.bookstore.service.product;

import az.atl.bookstore.dto.ProductDto;
import az.atl.bookstore.entities.CategoryEntity;
import az.atl.bookstore.entities.ProductEntity;
import az.atl.bookstore.repository.CategoryRepository;
import az.atl.bookstore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductEntity postProduct(Long categoryId, ProductDto productDto) throws IOException {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productDto.getName());
            productEntity.setPrice(productDto.getPrice());
            productEntity.setDescription(productDto.getDescription());
//            productEntity.setImage(productDto.getImage().getBytes());
            productEntity.setCategory(optionalCategory.get());
            return productRepository.save(productEntity);
        }
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductEntity::getProductDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity productEntity = optionalProduct.get();
            return productEntity.getProductDto();
        }
        return null;
    }

    @Override
    public ProductDto updateProduct(Long categoryId, Long productId, ProductDto productDto) throws IOException {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(categoryId);
        Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
        if (optionalCategory.isPresent() && optionalProduct.isPresent()) {
            ProductEntity productEntity = optionalProduct.get();
            productEntity.setName(productDto.getName());
            productEntity.setDescription(productDto.getDescription());
            productEntity.setPrice(productDto.getPrice());
            productEntity.setCategory(optionalCategory.get());
//            if (productDto.getImage() != null)
//                productEntity.setImage(productDto.getImage().getBytes());
            ProductEntity updateProduct = productRepository.save(productEntity);
            ProductDto updateProductDto = new ProductDto();
            updateProductDto.setId(updateProduct.getId());
            return updateProductDto;
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty())
            throw new IllegalArgumentException("Product with id " + id + " not found");
        productRepository.deleteById(id);
    }
}
