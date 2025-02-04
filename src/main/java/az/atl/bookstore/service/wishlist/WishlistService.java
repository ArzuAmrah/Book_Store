package az.atl.bookstore.service.wishlist;

import az.atl.bookstore.entities.WishlistEntity;
import az.atl.bookstore.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class WishlistService {
    private final WishlistRepository wishlistRepository;

    public List<WishlistEntity> getWishlistByUser(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }
}
