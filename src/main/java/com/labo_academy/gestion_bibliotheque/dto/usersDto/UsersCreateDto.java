package com.labo_academy.gestion_bibliotheque.dto.usersDto;

import java.time.LocalDate;

import com.labo_academy.gestion_bibliotheque.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UsersCreateDto {

    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String password;
    private String email;
    private String address;
    private Role role;

    // Constructeur
    public UsersCreateDto(String lastName, String firstName, LocalDate birthDate, String password, String email, String address, Role role) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.password = password;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    // Constructeur
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
