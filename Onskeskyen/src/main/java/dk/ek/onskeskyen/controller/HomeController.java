package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.model.Wishlist;
import dk.ek.onskeskyen.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    WishListRepo wishListRepo;

    @GetMapping("/")
    public String getHome(Model model){
        ArrayList<Wishlist> lists = wishListRepo.getAllWishLists();

        model.addAttribute("lists", lists);
        return "home";
    }

}
