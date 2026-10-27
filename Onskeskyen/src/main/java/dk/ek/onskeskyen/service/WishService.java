package dk.ek.onskeskyen.service;

import dk.ek.onskeskyen.model.Wish;
import dk.ek.onskeskyen.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishService {

    @Autowired
    WishRepo wishRepo;

    public Wish createWish(String title, double price, String note, String link, String wishImg, boolean priority, int wishListId) {
        Wish wish = new Wish(title, price, note, link, wishImg, priority, wishListId);
        wishRepo.save(wish);
        return wish;
    }

    public void editWish(int wishId, String title, double price, String note, String link, String wishImg, boolean priority, int wishlistId) {
        wishRepo.updateWish(wishId, title, price, note, link, wishImg, priority, wishlistId);
    }

    public void deleteWish(int wishId) {
        wishRepo.deleteWish(wishId);
    }
}
