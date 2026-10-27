package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.repository.WishlistRepo;
import dk.ek.onskeskyen.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WishlistController {

    private WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/getCreateWishlist")
    public String getCreateWishlist() {
        return "createWishlist";

    }

    @PostMapping ("/postCreateWishlist")
    public String postCreateWishlist(
            @RequestParam("wishlistTitle") String wishlistTitle) {

        wishlistService.createWishlist(wishlistTitle, 1);

        return "redirect:/wishlist";
    }

    @PostMapping ("/postDeleteWishlist")
    public String postDeleteWishlist(
            @RequestParam("wishlistId") int wishlistId

    ) {

        wishlistService.deleteWishlist(wishlistId, 1);

        return "redirect:/wishlist";

    }
}
