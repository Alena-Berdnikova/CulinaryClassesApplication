package org.berdnikova.culinary.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cooking_class_id")
    private CookingClass cookingClass;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

}

