package dk.ek.onskeskyen.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getImg(String profilePicture) {
        String img = null;

        if (profilePicture.contains("blue")) {
            img = "BluePicture.png";
        } else if (profilePicture.contains("red")) {
            img = "RedPicture.png";
        } else if (profilePicture.contains("yellow")) {
            img = "YellowPicture.png";
        } else if (profilePicture.contains("orange")) {
            img = "OrangePicture.png";
        } else if (profilePicture.contains("avatar1")) {
            img = "avatar1.png";
        } else if (profilePicture.contains("avatar2")) {
            img = "avatar2.png";
        }
        return img;
    }

}
