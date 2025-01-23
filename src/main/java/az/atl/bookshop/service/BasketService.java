package az.atl.bookshop.service;

import az.atl.bookshop.entities.BasketEntity;
import az.atl.bookshop.entities.ProductEntity;
import az.atl.bookshop.entities.UserEntity;
import az.atl.bookshop.repository.BasketRepository;
import az.atl.bookshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private BasketRepository basketRepository;

    private ProductRepository productRepository;

    public List<BasketEntity> getBasketByUser(Long userId){
        return basketRepository.findByUserId(userId);
    }

    public BasketEntity addProductToBasket(Long userId, Long productId, Long quantity){
       ProductEntity productEntity = productRepository.findById(productId)
               .orElseThrow(() -> new IllegalArgumentException("Product not found"));

       BasketEntity basketEntity = new BasketEntity();
       basketEntity.setUser(new UserEntity());
       basketEntity.setProduct(productEntity);
       basketEntity.setQuantity(quantity);

       return basketRepository.save(basketEntity);
    }

    public void clearBasket(Long userId){
        List<BasketEntity> userBasket = basketRepository.findByUserId(userId);
        basketRepository.deleteAll(userBasket);
    }
}
