package hr.algebra.jwpproject.controller.user;

import hr.algebra.jwpproject.service.UserService;
import hr.algebra.jwpproject.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;


    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerIndex(){return "register";}
    @PostMapping("/register")
    public String saveUser(@ModelAttribute("newUser")User user, Model model){
        User existing = userService.findByUsername(user.getUsername());
        if (existing != null){
            model.addAttribute("ErrorMessage","User with that username exists");
        } else {
            user.setRole("ROLE_USER");
            userService.saveUser(user);
            model.addAttribute("Success","Registration has been completed successfully");
        }

        return "register";
    }

}
