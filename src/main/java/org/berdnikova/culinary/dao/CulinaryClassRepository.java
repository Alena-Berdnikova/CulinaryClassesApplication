package org.berdnikova.culinary.dao;

import org.berdnikova.culinary.model.CulinaryClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CulinaryClassRepository extends JpaRepository<CulinaryClass, Long> {
    List<CulinaryClass> findByInstructor(String instructor);
}
