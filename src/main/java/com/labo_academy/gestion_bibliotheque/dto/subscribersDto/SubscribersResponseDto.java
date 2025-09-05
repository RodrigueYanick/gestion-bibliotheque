package com.labo_academy.gestion_bibliotheque.dto.subscribersDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersResponseDto;

import com.labo_academy.gestion_bibliotheque.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SubscribersResponseDto extends UsersResponseDto {

    private String idNumber;
    private boolean statut;

    public SubscribersResponseDto(Long id, String lastName, String firstName, LocalDate birthDate, String email, String address, Role role, boolean statut) {
        super(id, lastName, firstName, birthDate, email, address, role);
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
