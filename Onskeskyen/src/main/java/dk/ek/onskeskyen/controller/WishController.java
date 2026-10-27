package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.repository.WishlistRepo;
import dk.ek.onskeskyen.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishController {

    @Autowired
    WishService wishService;

    @GetMapping("/getCreateWish")
    public String getCreateWish(@RequestParam("wishlistId") int wishlistId, Model model) {

        model.addAttribute("wishlistId", wishlistId);
        return "createWish";
    }

    @GetMapping("/getEditWish")
    public String editWish(@RequestParam("wishId") int wishId, @RequestParam("title") String title, @RequestParam("price") double price, @RequestParam("note") String note, @RequestParam("link") String link, @RequestParam("wishImg") String wishImg, @RequestParam("priority") boolean priority, @RequestParam("wishlistId") int wishlistId, Model model) {

        model.addAttribute("wishId", wishId);
        model.addAttribute("title", title);
        model.addAttribute("price", price);
        model.addAttribute("note", note);
        model.addAttribute("link", link);
        model.addAttribute("wishImg", wishImg);
        model.addAttribute("priority", priority);
        model.addAttribute("wishlistId", wishlistId);
        return "editWish";
    }

    @PostMapping("/postCreateWish")
    public String postCreateWish(@RequestParam("title") String title, @RequestParam("price") double price, @RequestParam(value = "note", required = false) String note, @RequestParam(value = "link", required = false) String link, @RequestParam(value = "wishImg", required = false) String wishImg, @RequestParam(value = "priority", defaultValue = "false") boolean priority, @RequestParam("wishlistId") int wishlistId) {

        if (wishImg == null || wishImg.isBlank()) {
            wishImg = "../images/defaultImages/defaultcoverimg.png";
        }

        wishService.createWish(title, price, note, link, wishImg, priority, wishlistId);

        return "redirect:/getWishes?wishlistId=" + wishlistId;
    }

    @PostMapping("/postEditWish")
    public String postEditWish(@RequestParam("title") String title, @RequestParam("price") double price, @RequestParam(value = "note", required = false) String note, @RequestParam(value = "link", required = false) String link, @RequestParam(value = "wishImg", required = false) String wishImg, @RequestParam(value = "priority", defaultValue = "false") boolean priority, @RequestParam("wishId") int wishId, @RequestParam("wishlistId") int wishlistId) {

        wishService.editWish(wishId, title, price, note, link, wishImg, priority, wishlistId);

        return "redirect:/getWishes?wishlistId=" + wishlistId;
    }

    @PostMapping("/postDeleteWish")
    public String postDeleteWish(@RequestParam("wishId") int wishId, @RequestParam("wishlistId") int wishlistId) {

        wishService.deleteWish(wishId);

        return "redirect:/getWishes?wishlistId=" + wishlistId;
    }
}