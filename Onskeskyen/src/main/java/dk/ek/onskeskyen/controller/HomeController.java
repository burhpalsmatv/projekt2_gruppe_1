package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.model.Wish;
import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishListRepo;
import dk.ek.onskeskyen.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    WishListRepo wishListRepo;

    @Autowired
    WishRepo wishRepo;

    @GetMapping("/")
    public String getHome(Model model){
        ArrayList<Wishlist> lists = wishListRepo.getAllWishLists();

        model.addAttribute("lists", lists);
        return "home";
    }

    @GetMapping("/wishTest")
    public String getWishes(Model model){
        ArrayList<Wish> listOfWishes;

        listOfWishes = wishRepo.getAllWishes();

        model.addAttribute("listOfWishes", listOfWishes);

        return "wishTest";
    }



}
