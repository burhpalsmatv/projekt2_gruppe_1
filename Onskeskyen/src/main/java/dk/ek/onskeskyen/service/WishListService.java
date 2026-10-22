package dk.ek.onskeskyen.service;

import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishListRepo;

import java.time.LocalDate;

public class WishListService {

    public Wishlist createWishList(String owner, LocalDate date, int wishListId, String coverImg) {

        Wishlist wishlist = new Wishlist(owner, date, wishListId);

        // Wishlist wishlistAfterSave = WishListRepo.save()

        return wishlist;
    }
}
