package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.service.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WishListController {

    private WishListService wishlistService;

    @PostMapping ("/createWishlist")
    public String createWishlist(
            @RequestParam("wishListId") int wishlistId,
            @RequestParam("wishListTitle") String wishlistTitle,
            @RequestParam("coverImg") String coverImg) {

        wishlistService.createWishList(wishlistId, wishlistTitle, coverImg);

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
