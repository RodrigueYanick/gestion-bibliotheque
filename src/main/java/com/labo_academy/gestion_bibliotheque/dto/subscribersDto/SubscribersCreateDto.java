package com.labo_academy.gestion_bibliotheque.dto.subscribersDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;

import java.time.LocalDate;

public class SubscribersCreateDto extends UsersCreateDto {

    private String idNumber;
    private boolean statut;

    public SubscribersCreateDto(String lastName, String firstName, LocalDate birthDate, String password, String email, String address, Role role,String idNumber,boolean statut) {
        super(lastName, firstName, birthDate, password, email, address, role);
        this.idNumber = idNumber;
        this.statut = statut;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
}
