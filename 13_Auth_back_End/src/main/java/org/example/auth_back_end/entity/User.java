package org.example.auth_back_end.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor
@AllArgsConstructor
@Builder // Lombok annotation to generate a builder pattern for the class
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
