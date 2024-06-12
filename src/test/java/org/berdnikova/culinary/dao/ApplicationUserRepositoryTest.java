package org.berdnikova.culinary.dao;

import org.berdnikova.culinary.dao.ApplicationUserRepository;
import org.berdnikova.culinary.model.ApplicationUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ApplicationUserRepositoryTest {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Test
    public void testFindByEmail() {
        ApplicationUser user = new ApplicationUser();
        user.setEmail("test@example.com");
        user.setPassword("password");
        userRepository.save(user);

        ApplicationUser foundUser = userRepository.findByEmail("test@example.com");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo("test@example.com");
    }
}
