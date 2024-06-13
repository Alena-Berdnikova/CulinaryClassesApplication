package org.berdnikova.culinary.controller;

import org.berdnikova.culinary.model.ApplicationUser;
import org.berdnikova.culinary.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.security.Principal;

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
        userService.create(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PutMapping("/update")
    public String updateProfile(@RequestParam String name, @RequestParam String phone, Principal principal) {
        ApplicationUser user = userService.findByEmail(principal.getName());
        user.setName(name);
        user.setPhone(phone);
        userService.save(user);
        return "cookingclasses";
    }
    @GetMapping("/editprofile")
    public String showEditProfileForm(Model model, Principal principal) {
        ApplicationUser user = userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "editprofile";
    }

    @GetMapping("/cookingclasses")
    public String cookingclasses() {
        return "cookingclasses";
    }
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/current-user")
    public ApplicationUser getCurrentUser() {
        return userService.getCurrentUser();
    }
}

