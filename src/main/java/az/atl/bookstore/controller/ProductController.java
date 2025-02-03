package az.atl.bookstore.controller;

import az.atl.bookstore.dto.ProductDto;
import az.atl.bookstore.entities.ProductEntity;
import az.atl.bookstore.service.customer.CustomerService;
import az.atl.bookstore.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final CustomerService customerService;
    private final ProductService productService;

    // Müştəri üçün məhsulların əldə edilməsi
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = customerService.getAllProducts();
        return ResponseEntity.ok(productDtoList);
    }

    // Məhsul axtarışı
    @GetMapping("/search/{title}")
    public ResponseEntity<List<ProductDto>> searchProductByTitle(@PathVariable String title) {
        List<ProductDto> productDtoList = customerService.getProductsByTitle(title);
        return ResponseEntity.ok(productDtoList);
    }

    // Admin üçün məhsul əlavə etmə
    @PostMapping("/category/{categoryId}")
    public ResponseEntity<ProductEntity> postProduct(@PathVariable Long categoryId, @ModelAttribute ProductDto productDto) throws IOException {
        ProductEntity postedProduct = productService.postProduct(categoryId, productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(postedProduct);
    }

    // Admin üçün bütün məhsulların əldə edilməsi
    @GetMapping("/admin")
    public ResponseEntity<List<ProductDto>> getAllAdminProducts() {
        List<ProductDto> productDtoList = productService.getAllProducts();
        return ResponseEntity.ok(productDtoList);
    }

    // Admin üçün məhsul yeniləmə
    @GetMapping("/admin/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id) {
        ProductDto productDto = productService.getProductById(id);
        if (productDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productDto);
    }

    // Admin üçün məhsul yeniləmə (PUT)
    @PutMapping("/category/{categoryId}/product/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long categoryId, @PathVariable Long productId, @ModelAttribute ProductDto productDto) throws IOException {
        ProductDto updatedProduct = productService.updateProduct(categoryId, productId, productDto);
        if (updatedProduct == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
        return ResponseEntity.ok(updatedProduct);
    }

    // Admin üçün məhsul silmə
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
