package az.atl.bookstore.controller;

import az.atl.bookstore.entities.WishlistEntity;
import az.atl.bookstore.service.wishlist.WishlistService;
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

