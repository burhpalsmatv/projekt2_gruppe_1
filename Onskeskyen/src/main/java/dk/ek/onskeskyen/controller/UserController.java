package dk.ek.onskeskyen.controller;

import dk.ek.onskeskyen.model.User;
import dk.ek.onskeskyen.repository.UserRepo;
import dk.ek.onskeskyen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @GetMapping("/showUser")
    public String showUser(@RequestParam ("userId") int userId, Model model) {
        return "userId";
    }


    @GetMapping("/getCreateUser")
    public String createUser(){
        return "createUser";
    }

    @PostMapping("/saveCreateUser")
    public String postCreateUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastname") String lastName,
            @RequestParam("userId") int userId,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("age") int age,
            @RequestParam("password") String password,
            @RequestParam("profilePicture") String profilePicture){

        String img = userService.getImg(profilePicture);

        User user = new User(userId, firstName, lastName, email, profilePicture, phoneNumber, password, age);
        userRepo.saveUser(user);
        return "redirect:/";
    }


    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int userId) {
        userRepo.deleteUser(userId);
        return "redirect:/";
    }



}
