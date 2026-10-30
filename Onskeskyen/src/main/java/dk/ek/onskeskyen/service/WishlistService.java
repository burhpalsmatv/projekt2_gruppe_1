package dk.ek.onskeskyen.service;

import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishlistsRepo;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

    public final WishlistsRepo wishlistsRepo;

    public WishlistService(WishlistsRepo wishlistsRepo) {
        this.wishlistsRepo = wishlistsRepo;
    }

    public Wishlist createWishlist(String wishlistTitle, int userWishlistId) {
        Wishlist wishlist = new Wishlist(userWishlistId, wishlistTitle);
        wishlistsRepo.save(wishlist); // Gem i database
        return wishlist;
    }

    public void deleteWishlist(int wishlistId, int userId) {
        wishlistsRepo.deleteWishlist(wishlistId, userId);
    }
}
