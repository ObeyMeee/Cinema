package ua.com.andromeda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.andromeda.entities.User;
import ua.com.andromeda.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String showUserForm(@ModelAttribute User user){
        return "users/new-user";
    }

    @PostMapping
    public String processUser(@ModelAttribute(name = "user") @Valid User user,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "users/new-user";
        }
        userService.saveOrUpdate(user);
        return "redirect:/movies/home";
    }
}
