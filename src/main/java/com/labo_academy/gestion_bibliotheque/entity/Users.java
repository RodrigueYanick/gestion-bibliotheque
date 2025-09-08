package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "address", length = 100)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    
    // L’URL ou chemin d’accès à l’image de profil.
    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDate lastUpdate;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDelete = false;

    // Constructeurs
    public Users() {}

    public Users(Long id, String lastName, String firstName, LocalDate birthDate, String password,
                 String email, String address, Role role, String imageUrl,
                 LocalDate creationDate, LocalDate lastUpdate, boolean isDelete) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.password = password;
        this.email = email;
        this.address = address;
        this.role = role;
        this.imageUrl = imageUrl;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
        this.isDelete = isDelete;
    }

    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDate.now();
        this.lastUpdate = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdate = LocalDate.now();
    }
}
