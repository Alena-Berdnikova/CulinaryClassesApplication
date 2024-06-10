package org.berdnikova.culinary.controller;

import org.berdnikova.culinary.model.ApplicationUser;
import org.berdnikova.culinary.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new ApplicationUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid ApplicationUser user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginForm(@ModelAttribute("user") @Valid ApplicationUser user) {
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}

