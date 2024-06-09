package org.berdnikova.culinary.controller;


import org.berdnikova.culinary.model.ApplicationUser;
import org.berdnikova.culinary.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService userService;

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<ApplicationUser> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "all-users";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new ApplicationUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") ApplicationUser user) {
        userService.saveUser(user);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        ApplicationUser user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, @ModelAttribute("user") ApplicationUser user) {
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/users/all";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/users/all";
    }
}
