package org.berdnikova.culinary.dao;

import org.berdnikova.culinary.model.ApplicationUser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ApplicationUserRepositoryTest {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Test
    public void testFindByEmail() {
        // Arrange
        ApplicationUser user = new ApplicationUser();
        user.setEmail("test@example.com");
        user.setName("Test User");
        user.setPhone("1234567890");
        user.setPassword("password");
        user.setClasses("Cooking Basics");
        user.setContact("Email");
        applicationUserRepository.save(user);

        // Act
        ApplicationUser foundUser = applicationUserRepository.findByEmail("test@example.com");

        // Assert
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo("test@example.com");
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1@example.com", "test2@example.com"})
    public void testFindByEmailParameterized(String email) {
        // Arrange
        ApplicationUser user = new ApplicationUser();
        user.setEmail(email);
        user.setName("Test User");
        user.setPhone("1234567890");
        user.setPassword("password");
        user.setClasses("Cooking Basics");
        user.setContact("Email");
        applicationUserRepository.save(user);

        // Act
        ApplicationUser foundUser = applicationUserRepository.findByEmail(email);

        // Assert
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo(email);
    }
}
