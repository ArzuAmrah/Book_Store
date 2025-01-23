package az.atl.bookshop.controller;

import az.atl.bookshop.entities.BasketEntity;
import az.atl.bookshop.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/basket")
public class BasketController {

    private BasketService basketService;

    @GetMapping("/basket")
    public List<BasketEntity> getBasketByUser(@PathVariable Long userId) {
        return basketService.getBasketByUser(userId);
    }

    @PostMapping("/add")
    public BasketEntity addBasket(@RequestParam Long userId, @RequestParam Long productId,@RequestParam Long quantity){
        return basketService.addProductToBasket(userId, productId, quantity);
    }

    @DeleteMapping("/clear/{userId}")
    public String clearBasket(@PathVariable Long userId){
        basketService.clearBasket(userId);
        return "Basket cleared successfully!";
    }
}
