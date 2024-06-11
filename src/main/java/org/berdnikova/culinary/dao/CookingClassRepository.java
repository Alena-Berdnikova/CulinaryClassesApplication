package org.berdnikova.culinary.dao;


import org.berdnikova.culinary.model.CookingClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CookingClassRepository extends JpaRepository<CookingClass, Long>, JpaSpecificationExecutor<CookingClass> {
}

