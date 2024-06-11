package org.berdnikova.culinary.service;

import org.berdnikova.culinary.model.CookingClass;
import org.berdnikova.culinary.model.ApplicationUser;
import org.berdnikova.culinary.dao.CookingClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookingClassService {

    @Autowired
    private CookingClassRepository cookingClassRepository;

    public List<CookingClass> findAllSorted(String sortBy) {
        return cookingClassRepository.findAll(Sort.by(sortBy));
    }

    public Optional<CookingClass> findById(Long id) {
        return cookingClassRepository.findById(id);
    }

    public CookingClass save(CookingClass cookingClass) {
        return cookingClassRepository.save(cookingClass);
    }

    public void enrollStudent(CookingClass cookingClass, ApplicationUser student) {
        cookingClass.getStudents().add(student);
        cookingClassRepository.save(cookingClass);
    }
}

