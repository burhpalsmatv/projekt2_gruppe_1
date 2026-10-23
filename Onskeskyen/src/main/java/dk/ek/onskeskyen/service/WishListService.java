package dk.ek.onskeskyen.service;

import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishlistRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WishListService {

    WishlistRepo wishlistRepo = new WishlistRepo(); // reference objekt

    public Wishlist createWishList(String wishlistTitle) {
        Wishlist wishlist = new Wishlist(wishlistTitle);
        wishlistRepo.save(wishlist); // Gem i databaseg
        return wishlist;
    }

    public void deleteWishlist(int wishlistId, int userId) {
        wishlistRepo.deleteWishList(wishlistId, userId);
    }
}
