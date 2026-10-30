package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.model.Wish;
import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishesRepo;
import dk.ek.onskeskyen.repository.WishlistsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    WishlistsRepo wishlistsRepo;

    @Autowired
    WishesRepo wishesRepo;

    @GetMapping("/index")
    public String mainPage(Model model) {
        return "index";
    }

    @GetMapping("/omos")
    public String omos() {
        return "omos";
    }

    @GetMapping("/popularwishes")
    public String popularWishes() {
        return "popularwishes";
    }

    @GetMapping("/wishlist")
    public String getWishlist(Model model) {
        List<Wishlist> listOfWishlist = wishlistsRepo.getAllWishlists();
        model.addAttribute("listOfWishlist", listOfWishlist);

        return "wishlist";
    }

    /**
     * Gets wishes.
     *
     * @param model      the model
     * @param wishlistId the wishlist id
     * @return the wishes
     * <p>
     * The homeController receives a get request from the view, asks the repo (see wishRepo) to retrieve all wishes and
     * adds the data to the model. Then the controller redirects to the HTML page that displays the wishes.
     * See wishes.HTML
     */
    @GetMapping("/getWishes")
    public String getWishes(Model model, @RequestParam("wishlistId") int wishlistId) {
        List<Wish> listOfWishes = wishesRepo.getAllWishes(wishlistId);
        model.addAttribute("listOfWishes", listOfWishes);
        model.addAttribute("wishlistId", wishlistId);
        return "wishes";
    }
}
