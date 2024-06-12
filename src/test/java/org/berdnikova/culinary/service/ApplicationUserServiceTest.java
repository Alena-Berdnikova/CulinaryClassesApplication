package org.berdnikova.culinary.service;

import org.berdnikova.culinary.model.ApplicationUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationUserServiceTest {
    @Autowired
    private ApplicationUserService userService;

    @Test
    public void testSaveUser() {
        ApplicationUser user = new ApplicationUser();
        user.setEmail("test@example.com");
        user.setPassword("password");

        ApplicationUser savedUser = userService.save(user);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getEmail()).isEqualTo("test@example.com");
    }
}