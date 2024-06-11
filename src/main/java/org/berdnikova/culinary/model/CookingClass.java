package org.berdnikova.culinary.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class CookingClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String duration;
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany
    @JoinTable(
            name = "cooking_class_student",
            joinColumns = @JoinColumn(name = "cooking_class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<ApplicationUser> students = new HashSet<>();

}