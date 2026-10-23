package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.service.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WishListController {

    private WishListService wishlistService;

    @PostMapping ("/wishlist")
    public String createWishlist(
            @RequestParam int wishlistId,
            @RequestParam String wishlistTitle,
            @RequestParam String coverImg) {

        wishlistService.createWishList(wishlistId, wishlistTitle, coverImg);

        return "/wishlist";
    }
}
