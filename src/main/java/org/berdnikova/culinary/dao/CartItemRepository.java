package org.berdnikova.culinary.dao;

import org.berdnikova.culinary.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);
    void deleteByUserIdAndId(Long userId, Long id);
}

