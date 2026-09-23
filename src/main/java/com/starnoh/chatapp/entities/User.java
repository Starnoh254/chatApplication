package com.starnoh.chatapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false ,name = "first_name")
    private String firstName;

    @Column(nullable = false ,name = "last_name")
    private String lastName;

    @Column(nullable = false ,name = "email", unique = true)
    private String email;

    @Column(nullable = false ,name = "password")
    private String password;

}
