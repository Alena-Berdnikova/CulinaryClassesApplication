package org.berdnikova.culinary.service;

import org.berdnikova.culinary.dao.ApplicationUserRepository;
import org.berdnikova.culinary.model.ApplicationUser;
import org.berdnikova.culinary.model.CulinaryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ApplicationUserService {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void saveUser(ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<ApplicationUser> getAllUsers() {
        return userRepository.findAll();
    }

    public List<ApplicationUser> getAllUsersByClass(CulinaryClass culinaryClass) {
        return userRepository.findByClass(culinaryClass);
    }

    public ApplicationUser getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteUser(Integer id) {
        ApplicationUser user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    public ApplicationUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
