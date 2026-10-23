
package dk.ek.onskeskyen.controller;

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
    public String createWish(
            @RequestParam("wishListId") int wishListId,
            Model model) {

        model.addAttribute("wishListId", wishListId);
        return "redirect:/createWish?wishListId=" + wishListId;
    }

    @PostMapping("/postCreateWish")
    public String postCreateWish(
            @RequestParam("title") String title,
            @RequestParam("price") double price,
            @RequestParam(value = "note", required = false) String note,
            @RequestParam(value = "link", required = false) String link,
            @RequestParam(value = "wishImg", required = false) String wishImg,
            @RequestParam(value = "priority", defaultValue = "false") boolean priority,
            @RequestParam("wishListId") int wishListId) {

        wishService.createWish(
                title, price, note, link, wishImg, priority, wishListId
        );

        return "redirect:/getWishes?wishListId=" + wishListId;
    }
}
