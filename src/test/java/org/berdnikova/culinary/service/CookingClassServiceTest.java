package org.berdnikova.culinary.service;


import org.berdnikova.culinary.model.CookingClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CookingClassServiceTest {

    @Autowired
    private CookingClassService cookingClassService;

    @Test
    public void testSaveCookingClass() {
        CookingClass cookingClass = new CookingClass();
        cookingClass.setName("Baking Basics");
        cookingClass.setPrice(50.0);

        CookingClass savedClass = cookingClassService.save(cookingClass);
        assertThat(savedClass).isNotNull();
        assertThat(savedClass.getName()).isEqualTo("Baking Basics");
    }
}
