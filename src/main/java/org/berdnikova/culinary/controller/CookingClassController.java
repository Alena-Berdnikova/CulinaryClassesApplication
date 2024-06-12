package org.berdnikova.culinary.controller;

import org.berdnikova.culinary.model.CookingClass;
import org.berdnikova.culinary.model.ApplicationUser;
import org.berdnikova.culinary.service.CookingClassService;
import org.berdnikova.culinary.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cooking-classes")
public class CookingClassController {

    @Autowired
    private CookingClassService cookingClassService;

    @Autowired
    private ApplicationUserService studentService;

    @GetMapping
    public List<CookingClass> getAllClasses(@RequestParam(required = false) String sortBy) {
        if (sortBy != null) {
            return cookingClassService.findAllSorted(sortBy);
        } else {
            return cookingClassService.findAllSorted("id");
        }
    }

    @GetMapping("/{id}")
    public Optional<CookingClass> getClassById(@PathVariable Long id) {
        return cookingClassService.findById(id);
    }

    @PostMapping
    public CookingClass createClass(@RequestBody CookingClass cookingClass) {
        return cookingClassService.save(cookingClass);
    }

    @PostMapping("/{classId}/enroll/{studentId}")
    public CookingClass enrollStudent(@PathVariable Long classId, @PathVariable Long studentId) {
        Optional<CookingClass> cookingClassOpt = cookingClassService.findById(classId);
        Optional<ApplicationUser> studentOpt = studentService.findById(studentId);

        if (cookingClassOpt.isPresent() && studentOpt.isPresent()) {
            CookingClass cookingClass = cookingClassOpt.get();
            ApplicationUser student = studentOpt.get();
            cookingClassService.enrollStudent(cookingClass, student);
            return cookingClass;
        } else {
            throw new RuntimeException("Class or Student not found");
        }
    }

    @PostMapping("/{classId}/add-to-cart")
    public void addToCart(@PathVariable Long classId, Principal user) {
        Optional<CookingClass> cookingClassOpt = cookingClassService.findById(classId);

        if (cookingClassOpt.isPresent()) {
            CookingClass cookingClass = cookingClassOpt.get();
            cookingClassService.addToCart(cookingClass, user.getName());
        } else {
            throw new RuntimeException("Class or User not found");
        }
    }
}

