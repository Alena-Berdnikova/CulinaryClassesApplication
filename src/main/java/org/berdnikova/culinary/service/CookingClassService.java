package org.berdnikova.culinary.service;

import jakarta.transaction.Transactional;
import org.berdnikova.culinary.dao.ApplicationUserRepository;
import org.berdnikova.culinary.dao.CartItemRepository;
import org.berdnikova.culinary.model.CartItem;
import org.berdnikova.culinary.model.CookingClass;
import org.berdnikova.culinary.model.ApplicationUser;
import org.berdnikova.culinary.dao.CookingClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookingClassService {

    @Autowired
    private CookingClassRepository cookingClassRepository;
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private CartItemRepository cartItemRepository;
    public List<CookingClass> findAllSorted(String sortBy) {
        return cookingClassRepository.findAll(Sort.by(sortBy));
    }

    public Optional<CookingClass> findById(Long id) {
        return cookingClassRepository.findById(id);
    }

    public CookingClass save(CookingClass cookingClass) {
        return cookingClassRepository.save(cookingClass);
    }

    public void enrollStudent(CookingClass cookingClass, ApplicationUser student) {
        cookingClass.getStudents().add(student);
        cookingClassRepository.save(cookingClass);
    }
    public void addToCart(CookingClass cookingClass, String username) {
        CartItem cartItem = new CartItem();
        cartItem.setCookingClass(cookingClass);
        cartItem.setUser(applicationUserRepository.findByEmail(username));
        cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartItems(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }
    @Transactional
    public void deleteCartItem(Long userId, Long itemId) {
        cartItemRepository.deleteByUserIdAndId(userId, itemId);
    }
}

