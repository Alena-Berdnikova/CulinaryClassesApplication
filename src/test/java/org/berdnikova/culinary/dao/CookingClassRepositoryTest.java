package org.berdnikova.culinary.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.berdnikova.culinary.model.CookingClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CookingClassRepositoryTest {

        @Autowired
        private CookingClassRepository cookingClassRepository;

        @Test
        public void testFindClassesCheaperThan() {
            // Create test data
            CookingClass cookingClass1 = new CookingClass();
            cookingClass1.setName("Class A");
            cookingClass1.setPrice(50.0);
            cookingClassRepository.save(cookingClass1);

            CookingClass cookingClass2 = new CookingClass();
            cookingClass2.setName("Class B");
            cookingClass2.setPrice(30.0);
            cookingClassRepository.save(cookingClass2);

            BigDecimal priceThreshold = new BigDecimal(40.0);

            // Invoke the custom query method
            List<CookingClass> classes = cookingClassRepository.findClassesCheaperThan(priceThreshold);

            // Assert the results
            Assertions.assertEquals(1, classes.size());
            Assertions.assertEquals("Class B", classes.get(0).getName());
        }

    }
