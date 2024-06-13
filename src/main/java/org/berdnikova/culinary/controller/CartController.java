package org.berdnikova.culinary.controller;
import org.berdnikova.culinary.model.ApplicationUser;
import org.berdnikova.culinary.model.CartItem;
import org.berdnikova.culinary.service.CookingClassService;
import org.berdnikova.culinary.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CookingClassService cookingClassService;

    @Autowired
    private ApplicationUserService userService;

    @GetMapping("/cart")
    public String viewCart(Model model, Principal principal) {
        ApplicationUser user = userService.findByEmail(principal.getName());
        List<CartItem> cartItems = cookingClassService.getCartItems(user.getId());
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @GetMapping("/cart/items")
    @ResponseBody
    public List<CartItem> getCartItems(Principal principal) {
        ApplicationUser user = userService.findByEmail(principal.getName());
        return cookingClassService.getCartItems(user.getId());
    }
    @DeleteMapping("/cart/items/{itemId}")
    @ResponseBody
    public void deleteCartItem(@PathVariable Long itemId, Principal principal) {
        ApplicationUser user = userService.findByEmail(principal.getName());
        cookingClassService.deleteCartItem(user.getId(), itemId);
    }
}