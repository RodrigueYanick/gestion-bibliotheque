package com.labo_academy.gestion_bibliotheque.dto.authorDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class AuthorCreateDto {

    private String lastName;
    private String firstName;
    private String immatriculation;
    private String nationalite;

    // Constructor
    public AuthorCreateDto(String lastName, String firstName, String immatriculation, String nationalite) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.immatriculation = immatriculation;
        this.nationalite = nationalite;
    }

    // Getters and Setters
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
//





}
