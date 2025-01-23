package az.atl.bookshop.service;


import az.atl.bookshop.entities.WishlistEntity;
import az.atl.bookshop.repository.WishlistRepository;
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