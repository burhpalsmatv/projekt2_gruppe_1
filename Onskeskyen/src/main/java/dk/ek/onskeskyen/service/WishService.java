package dk.ek.onskeskyen.service;

import dk.ek.onskeskyen.model.Wish;
import dk.ek.onskeskyen.repository.WishesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishService {

    @Autowired
    WishesRepo wishesRepo;

    public void createWish(String title, double price, String note, String link, String wishImg, boolean priority, int wishlistId) {
        Wish wish = new Wish(title, price, note, link, wishImg, wishlistId, priority);
        wishesRepo.save(wish);
    }

    public void editWish(int wishId, String title, double price, String note, String link, String wishImg, boolean priority) {
        wishesRepo.updateWish(wishId, title, price, note, link, wishImg, priority);
    }

    public void deleteWish(int wishId) {
        wishesRepo.deleteWish(wishId);
    }
}
