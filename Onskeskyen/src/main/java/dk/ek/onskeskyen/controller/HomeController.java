package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.model.Wish;
import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishlistRepo;
import dk.ek.onskeskyen.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    WishlistRepo wishlistRepo;

    @Autowired
    WishRepo wishRepo;

    @GetMapping("/index")
    public String mainPage(Model model) {
        return "index";
    }

    @GetMapping("/omos")
    public String omos() {
        return "omos";
    }

    @GetMapping("/wishlist")
    public String getWishlist(Model model) {
        List<Wishlist> listOfWishlist = wishlistRepo.getAllWishlists();
        model.addAttribute("listOfWishlist", listOfWishlist);

        return "wishlist";
    }

    @GetMapping("/getWishes")
    public String getWishes(Model model, @RequestParam("wishListId") int wishListId) {
        List<Wish> listOfWishes = wishRepo.getAllWishes(wishListId);
        model.addAttribute("listOfWishes", listOfWishes);
        model.addAttribute("wishListId", wishListId);
        return "wishes";
    }
}
