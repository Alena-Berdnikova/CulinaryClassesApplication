package org.berdnikova.culinary.dao;

import org.berdnikova.culinary.model.ApplicationUser;
import org.berdnikova.culinary.model.CulinaryClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
        ApplicationUser findByEmail(String email);

    List<ApplicationUser> findByClass(CulinaryClass culinaryClass);
    }
