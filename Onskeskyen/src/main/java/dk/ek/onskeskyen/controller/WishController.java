
package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.model.Wish;
import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishRepo;
import dk.ek.onskeskyen.repository.WishlistRepo;
import dk.ek.onskeskyen.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@Controller
public class WishController {

    @Autowired
    WishService wishService;

    @Autowired
    WishlistRepo wishlistRepo;

    @GetMapping("/getCreateWish")
    public String getCreateWish(
            @RequestParam("wishlistId") int wishlistId,
            Model model) {

        model.addAttribute("wishlistId", wishlistId);
        return "createWish";
    }

    @PostMapping("/postCreateWish")
    public String postCreateWish(
            @RequestParam("title") String title,
            @RequestParam("price") double price,
            @RequestParam(value = "note", required = false) String note,
            @RequestParam(value = "link", required = false) String link,
            @RequestParam(value = "wishImg", required = false) String wishImg,
            @RequestParam(value = "priority", defaultValue = "false") boolean priority,
            @RequestParam("wishlistId") int wishlistId) {

        wishService.createWish(
                title, price, note, link, wishImg, priority, wishlistId
        );

        return "redirect:/getWishes?wishlistId=" + wishlistId;
    }
}
