package org.berdnikova.culinary.dao;


import org.berdnikova.culinary.model.CookingClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CookingClassRepository extends JpaRepository<CookingClass, Long>, JpaSpecificationExecutor<CookingClass> {
    @Query("SELECT c FROM CookingClass c WHERE c.price < :price")
    List<CookingClass> findClassesCheaperThan(@Param("price") BigDecimal price);

    @Query("SELECT c FROM CookingClass c JOIN c.students s WHERE s.id = :studentId")
    List<CookingClass> findClassesByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT c FROM CookingClass c ORDER BY c.name")
    List<CookingClass> findAllOrderByName();
}

