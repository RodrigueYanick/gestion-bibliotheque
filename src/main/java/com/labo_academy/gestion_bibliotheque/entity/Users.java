package com.labo_academy.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Users {

    // Definition des attributs

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastName", nullable = false, length = 255)
    private String lastName;

    @Column(name = "firstName", nullable = false, length = 255)
    private String firstName;

    @Column(name = "dateBirth", nullable = false, length = 255)
    private LocalDate dateBirth;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "adress", length = 255)
    private String adress;

    //@Column(name = "image",nullable = false)
    //private Image image;

    @Column(name = "creationDate", nullable = false, length = 255)
    private LocalDate creationDate;

    @Column(name = "lastUpdate", nullable = false, length = 255)
    private Date lastUpdate;

    @Column(name = "isDeleted", nullable = false, length = 255)
    private boolean isDelete;
}