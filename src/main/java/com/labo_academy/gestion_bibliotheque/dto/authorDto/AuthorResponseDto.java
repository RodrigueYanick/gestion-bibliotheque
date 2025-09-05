package com.labo_academy.gestion_bibliotheque.dto.authorDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class AuthorResponseDto {

    private Long id;
    private String lastName;
    private String firstName;
    private String immatriculation;
    private String nationalite;

    // Constructor
    public AuthorResponseDto(Long id, String lastName, String firstName, String immatriculation, String nationalite) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.immatriculation = immatriculation;
        this.nationalite = nationalite;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
}
