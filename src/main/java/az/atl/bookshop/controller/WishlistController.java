package az.atl.bookshop.controller;

import az.atl.bookshop.entities.WishlistEntity;
import az.atl.bookshop.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/wishlist")
public class WishlistController {

    private WishlistService wishlistService;

    @GetMapping("/{userId}")
    public List<WishlistEntity> getWishlistByUser(@PathVariable Long userId){
        return wishlistService.getWishlistByUser(userId);
    }

}
