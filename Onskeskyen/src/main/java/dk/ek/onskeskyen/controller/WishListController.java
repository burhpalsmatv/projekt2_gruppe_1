package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.service.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WishListController {

    private final WishListService wishlistService;

    public WishListController(WishListService wistlistService) {
        this.wishlistService = wistlistService;
    }

    @PostMapping ("/createWishlist")
    public String createWishlist(
            @RequestParam("wishListTitle") String wishlistTitle) {

        wishlistService.createWishList(wishlistTitle);

        return "/wishlist";
    }

    @PostMapping ("/deleteWishlist")
    public String deleteWishlist(
            @RequestParam("wishListId") int wishlistId,
            @RequestParam("userId") int userId

    ) {

        wishlistService.deleteWishlist(wishlistId, userId);

        return "/wishlist";

    }
}
