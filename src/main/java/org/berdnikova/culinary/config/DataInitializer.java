package org.berdnikova.culinary.config;

import org.berdnikova.culinary.model.CookingClass;
import org.berdnikova.culinary.model.Instructor;
import org.berdnikova.culinary.model.ApplicationUser;
import org.berdnikova.culinary.dao.CookingClassRepository;
import org.berdnikova.culinary.dao.InstructorRepository;
import org.berdnikova.culinary.dao.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class DataInitializer {

    @Autowired
    private CookingClassRepository cookingClassRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private ApplicationUserRepository studentRepository;
//uncomment during your first start of application
//    @Bean
//    CommandLineRunner initDatabase() {
//        return args -> {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
//
//            Instructor instructor1 = new Instructor();
//            instructor1.setName("Chef Alena Berdnikova");
//            instructorRepository.save(instructor1);
//
//            Instructor instructor2 = new Instructor();
//            instructor2.setName("Chef John Doe");
//            instructorRepository.save(instructor2);
//
//            CookingClass class1 = new CookingClass();
//            class1.setName("Basic Culinary Skills");
//            class1.setDuration("4 weeks");
//            class1.setStartDate(dateFormat.parse("June 1, 2024"));
//            class1.setInstructor(instructor1);
//            cookingClassRepository.save(class1);
//
//            CookingClass class2 = new CookingClass();
//            class2.setName("Advanced Culinary Arts");
//            class2.setDuration("6 weeks");
//            class2.setStartDate(dateFormat.parse("July 1, 2024"));
//            class2.setInstructor(instructor2);
//            cookingClassRepository.save(class2);
//
//            CookingClass class3 = new CookingClass();
//            class3.setName("Basic Pastry Class");
//            class3.setDuration("4 weeks");
//            class3.setStartDate(dateFormat.parse("June 1, 2024"));
//            class3.setInstructor(instructor1);
//            cookingClassRepository.save(class3);
//
//            CookingClass class4 = new CookingClass();
//            class4.setName("Advanced Pastry Class");
//            class4.setDuration("6 weeks");
//            class4.setStartDate(dateFormat.parse("July 1, 2024"));
//            class4.setInstructor(instructor2);
//            cookingClassRepository.save(class4);
//        };
//    }
}

