package dk.ek.onskeskyen.service;

import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishlistRepo;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    WishlistRepo wishlistRepo = new WishlistRepo(); // reference objekt

    public void createWishList(String wishlistTitle) {
        Wishlist wishlist = new Wishlist(wishlistTitle);
        wishlistRepo.save(wishlist); // Gem i databaseg
    }

    public void deleteWishlist(int wishlistId, int userId) {
        wishlistRepo.deleteWishList(wishlistId, userId);
    }
}
