package org.berdnikova.culinary.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.berdnikova.culinary.dao.CartItemRepository;
import org.berdnikova.culinary.model.CartItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CartItemRepositoryTest {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Test
    public void testFindByUserId() {

    }

    @Test
    public void testDeleteByUserIdAndId() {

    }
}
