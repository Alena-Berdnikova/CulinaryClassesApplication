package org.berdnikova.culinary.model;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Phone number is required")
    private String phone;

    @NotEmpty(message = "Password is required")
    private String password;

    @NotEmpty(message = "Classes selection is required")
    private String classes;

    @NotEmpty(message = "Contact method is required")
    private String contact;
}
