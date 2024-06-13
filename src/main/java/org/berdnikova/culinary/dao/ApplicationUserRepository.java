package org.berdnikova.culinary.dao;

import org.berdnikova.culinary.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByEmail(String email);
}