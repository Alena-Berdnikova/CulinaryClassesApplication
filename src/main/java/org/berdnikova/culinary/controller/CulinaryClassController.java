package org.berdnikova.culinary.controller;

import org.berdnikova.culinary.model.CulinaryClass;
import org.berdnikova.culinary.service.CulinaryClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class CulinaryClassController {
    @Autowired
    private CulinaryClassService service;

    @GetMapping
    public List<CulinaryClass> getAllClasses() {
        return service.getAllClasses();
    }
}