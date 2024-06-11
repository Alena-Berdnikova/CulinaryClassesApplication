package org.berdnikova.culinary.service;

import org.berdnikova.culinary.dao.ApplicationUserRepository;
import org.berdnikova.culinary.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserService {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ApplicationUser save(ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<ApplicationUser> findById(Long id) {
        return userRepository.findById(id);
    }

    public ApplicationUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
