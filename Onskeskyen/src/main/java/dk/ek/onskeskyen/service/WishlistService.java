package dk.ek.onskeskyen.service;

import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishlistRepo;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

    public final WishlistRepo wishlistRepo;

    public WishlistService(WishlistRepo wishlistRepo) {
        this.wishlistRepo = wishlistRepo;
    }

    public void createWishlist(String wishlistTitle, int userWishlistId) {
        Wishlist wishlist = new Wishlist(userWishlistId, wishlistTitle);
        wishlistRepo.save(wishlist); // Gem i database
    }

    public void deleteWishlist(int wishlistId, int userId) {
        wishlistRepo.deleteWishlist(wishlistId, userId);
    }
}
