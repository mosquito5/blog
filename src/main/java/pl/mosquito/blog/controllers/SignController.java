package pl.mosquito.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mosquito.blog.model.users.User;
import pl.mosquito.blog.model.users.UserRepository;
import pl.mosquito.blog.service.UserService;

@Controller
public class SignController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/singup")
    public String singUp(@ModelAttribute User user) {

        if(userRepository.findByName(user.getName()).isPresent()){
            return "redirect:/singup";
        }
        else {
            userService.addWithDefaultRole(user);
            return "redirect:/";
        }

    }

}
