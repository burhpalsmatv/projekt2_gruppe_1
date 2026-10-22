package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.model.Wish;
import dk.ek.onskeskyen.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishController {

    @Autowired
    WishRepo wishRepo;

    @GetMapping("/GetAddWish")
    public String addWish(){

        return "addWish";
    }

    @PostMapping("/saveAddWish")
    public String postAddWish(
            @RequestParam("title") String title,
            @RequestParam("price") int price,
            @RequestParam("note") String note,
            @RequestParam("link") String link,
            @RequestParam("wishImg") String wishImg,
            @RequestParam("priority") boolean priority,
            @RequestParam("wishListId") int wishListId) {

        Wish wish = new Wish(title, price, note, link, wishImg, wishListId, priority);
        wishRepo.save(wish);
        return "redirect:/";
    }

}
