package org.berdnikova.culinary.service;

import org.berdnikova.culinary.dao.ApplicationUserRepository;
import org.berdnikova.culinary.model.ApplicationUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import org.berdnikova.culinary.model.ApplicationUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ApplicationUserServiceTest {
    @Autowired
    private ApplicationUserService userService;

        @Mock
        private ApplicationUserRepository userRepository;

        @Mock
        private PasswordEncoder passwordEncoder;

        @InjectMocks
        private ApplicationUserService applicationUserService;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testSaveUser() {
            // Prepare data
            ApplicationUser user = new ApplicationUser();
            user.setEmail("test@example.com");
            user.setPassword("password");

            // Mock behavior
            Mockito.when(userRepository.save(Mockito.any(ApplicationUser.class))).thenReturn(user);

            // Invoke service method
            ApplicationUser savedUser = applicationUserService.save(user);

            // Verify
            Assertions.assertNotNull(savedUser);
            Assertions.assertEquals("test@example.com", savedUser.getEmail());
            Assertions.assertEquals("password", savedUser.getPassword()); // Assuming no encoding in save
        }

        @Test
        public void testCreateUser() {
            // Prepare data
            ApplicationUser user = new ApplicationUser();
            user.setEmail("test@example.com");
            user.setPassword("password");

            // Mock behavior
            Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn("encodedPassword");
            Mockito.when(userRepository.save(Mockito.any(ApplicationUser.class))).thenReturn(user);

            // Invoke service method
            ApplicationUser savedUser = applicationUserService.create(user);

            // Verify
            Assertions.assertNotNull(savedUser);
            Assertions.assertEquals("test@example.com", savedUser.getEmail());
            Assertions.assertEquals("encodedPassword", savedUser.getPassword()); // Check encoding
        }

        @Test
        public void testFindById() {
            // Prepare data
            Long userId = 1L;
            ApplicationUser user = new ApplicationUser();
            user.setId(userId);
            user.setEmail("test@example.com");

            // Mock behavior
            Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

            // Invoke service method
            Optional<ApplicationUser> foundUser = applicationUserService.findById(userId);

            // Verify
            Assertions.assertTrue(foundUser.isPresent());
            Assertions.assertEquals("test@example.com", foundUser.get().getEmail());
        }

        @Test
        public void testFindByEmail() {
            // Prepare data
            String email = "test@example.com";
            ApplicationUser user = new ApplicationUser();
            user.setEmail(email);

            // Mock behavior
            Mockito.when(userRepository.findByEmail(email)).thenReturn(user);

            // Invoke service method
            ApplicationUser foundUser = applicationUserService.findByEmail(email);

            // Verify
            Assertions.assertNotNull(foundUser);
            Assertions.assertEquals(email, foundUser.getEmail());
        }

        @Test
        public void testGetCurrentUser() {
            // Prepare data
            String username = "test@example.com";
            ApplicationUser user = new ApplicationUser();
            user.setEmail(username);

            // Mock security context
            UserDetails userDetails = new User(username, "password", null);
            SecurityContext securityContext = Mockito.mock(SecurityContext.class);
            SecurityContextHolder.setContext(securityContext);
            Mockito.when(securityContext.getAuthentication().getPrincipal()).thenReturn(userDetails);

            // Mock behavior
            Mockito.when(userRepository.findByEmail(username)).thenReturn(user);

            // Invoke service method
            ApplicationUser currentUser = applicationUserService.getCurrentUser();

            // Verify
            Assertions.assertNotNull(currentUser);
            Assertions.assertEquals(username, currentUser.getEmail());
        }
    }
