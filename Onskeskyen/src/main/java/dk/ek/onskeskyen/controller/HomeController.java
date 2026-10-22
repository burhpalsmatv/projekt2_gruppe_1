package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.model.Wish;
import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishlistRepo;
import dk.ek.onskeskyen.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    WishlistRepo wishlistRepo;
    WishRepo wishRepo;

    @GetMapping("/index")
    public String mainPage(Model model) {
        return "index";
    }

    @GetMapping("/wishlist")
    public String getWishlist(Model model) {
        List<Wishlist> listOfWishlist = wishlistRepo.getAllWishlists();
        model.addAttribute("listOfWishlist", listOfWishlist);
        return "wishlist";
    }

    @GetMapping("/wishes")
    public String getWishes(Model model) {
        List<Wish> listOfWishes = wishRepo.getAllWishes();
        model.addAttribute("listOfWishes", listOfWishes);
        return "wishes";
    }
}
