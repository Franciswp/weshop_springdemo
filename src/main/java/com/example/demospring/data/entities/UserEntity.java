package com.example.demospring.data.entities;

import com.example.demospring.data.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid2")
    private UUID id;

    @Column
    private String email;


    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "password_salt")
    private String passwordSalt;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Column
    private String name;

}