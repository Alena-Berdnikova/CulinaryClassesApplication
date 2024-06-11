package org.berdnikova.culinary.dao;

import org.berdnikova.culinary.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}

