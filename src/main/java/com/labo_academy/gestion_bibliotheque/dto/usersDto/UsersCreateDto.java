package com.labo_academy.gestion_bibliotheque.dto.usersDto;

import java.time.LocalDate;

import com.labo_academy.gestion_bibliotheque.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
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

}
