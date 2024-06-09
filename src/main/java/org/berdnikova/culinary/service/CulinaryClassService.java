package org.berdnikova.culinary.service;

import org.berdnikova.culinary.dao.CulinaryClassRepository;
import org.berdnikova.culinary.model.CulinaryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CulinaryClassService {
    @Autowired
    private CulinaryClassRepository repository;

    public List<CulinaryClass> getAllClasses() {
        return repository.findAll();
    }
}
